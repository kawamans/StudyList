# JSPのコツ

JSP（JavaServer Pages）は、HTMLの中にJavaコードを埋め込んで動的なページを作成する技術です。

---

## JSPの役割

```
┌─────────────────────────────────────────┐
│              JSP の役割                  │
│                                         │
│    「データを受け取って表示するだけ」      │
│                                         │
│    ✓ HTMLを生成する                      │
│    ✗ データベース操作しない              │
│    ✗ 複雑な計算しない                    │
└─────────────────────────────────────────┘
```

---

## 基本的なタグ

### 1. 出力タグ `<%= %>`

値を画面に出力します。

```jsp
<%-- 変数の値を出力 --%>
<p>こんにちは、<%= username %>さん</p>

<%-- メソッドの戻り値を出力 --%>
<p>タイトル: <%= recipe.getTitle() %></p>

<%-- 計算結果を出力 --%>
<p>合計: <%= price * quantity %>円</p>
```

### 2. スクリプトレット `<% %>`

Javaのコードを書きます（出力はしない）。

```jsp
<%
// 変数の宣言
String message = "Hello";

// 条件分岐
if (user != null) {
    // 処理
}

// ループ
for (int i = 0; i < 10; i++) {
    // 処理
}
%>
```

### 3. ディレクティブ `<%@ %>`

ページの設定を行います。

```jsp
<%-- 文字コードの設定（必須） --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- クラスのインポート --%>
<%@ page import="jp.co.recipe.dto.RecipeDTO" %>
<%@ page import="java.util.List" %>

<%-- 他のJSPを読み込む --%>
<%@ include file="../layout/header.jsp" %>
```

### 4. コメント `<%-- --%>`

JSPのコメント（ブラウザに送信されない）。

```jsp
<%-- これはJSPコメント（HTMLソースに出力されない） --%>

<!-- これはHTMLコメント（HTMLソースに出力される） -->
```

---

## よく使うパターン

### パターン1: サーブレットからデータを受け取る

```jsp
<%@ page import="jp.co.recipe.dto.RecipeDTO" %>
<%
// request.getAttribute() でサーブレットから渡されたデータを取得
RecipeDTO recipe = (RecipeDTO) request.getAttribute("recipe");
%>

<h1><%= recipe.getTitle() %></h1>
<p><%= recipe.getContent() %></p>
```

**サーブレット側：**
```java
request.setAttribute("recipe", recipe);  // ← これでJSPに渡す
request.getRequestDispatcher("/views/jsp/recipeDetail.jsp").forward(request, response);
```

### パターン2: リストをループで表示

```jsp
<%@ page import="jp.co.recipe.dto.RecipeDTO" %>
<%@ page import="java.util.List" %>
<%
List<RecipeDTO> recipeList = (List<RecipeDTO>) request.getAttribute("recipeList");
%>

<ul class="recipe-list">
<% for (RecipeDTO recipe : recipeList) { %>
    <li class="recipe-card">
        <h3><%= recipe.getTitle() %></h3>
        <p><%= recipe.getContent() %></p>
    </li>
<% } %>
</ul>
```

### パターン3: 条件分岐で表示を切り替え

```jsp
<%-- ログイン状態で表示を切り替え --%>
<% if (loginUser != null) { %>
    <p>ようこそ、<%= loginUser.getUsername() %>さん</p>
    <a href="logout">ログアウト</a>
<% } else { %>
    <a href="login.jsp">ログイン</a>
<% } %>
```

### パターン4: nullチェック

```jsp
<%-- 画像がある場合だけ表示 --%>
<% if (recipe.getImageFilename() != null && !recipe.getImageFilename().isEmpty()) { %>
    <img src="uploads/<%= recipe.getImageFilename() %>" alt="レシピ画像">
<% } %>
```

### パターン5: エラーメッセージの表示

```jsp
<%-- エラーがある場合だけ表示 --%>
<% if (request.getAttribute("error") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("error") %>
    </div>
<% } %>
```

### パターン6: ヘッダー・フッターの共通化

```jsp
<%-- header.jsp を読み込む --%>
<%@ include file="../layout/header.jsp" %>

<div class="content">
    <%-- ページ固有の内容 --%>
</div>

<%-- footer.jsp を読み込む --%>
<%@ include file="../layout/footer.jsp" %>
```

---

## コンテキストパスの扱い

### なぜ必要か？

```
開発環境: http://localhost:8080/recipe/home
本番環境: http://example.com/home

↓ パスが変わる可能性がある

<a href="/home">  ← NG: 環境によって動かない
<a href="<%= request.getContextPath() %>/home">  ← OK: 常に正しいパス
```

### 使い方

```jsp
<%-- リンク --%>
<a href="<%= request.getContextPath() %>/home">ホーム</a>
<a href="<%= request.getContextPath() %>/recipe/detail?id=<%= recipe.getId() %>">詳細</a>

<%-- フォームの送信先 --%>
<form action="<%= request.getContextPath() %>/LoginServlet" method="post">

<%-- CSS・画像 --%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<img src="<%= request.getContextPath() %>/uploads/<%= recipe.getImageFilename() %>">
```

---

## よくある間違いと対策

### 間違い1: JSPでデータベース操作

```jsp
<%-- NG: JSPでSQL実行 --%>
<%
Connection conn = DriverManager.getConnection(url, user, pass);
PreparedStatement ps = conn.prepareStatement("SELECT * FROM recipes");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    out.println(rs.getString("title"));
}
%>

<%-- OK: サーブレットで取得したデータを表示するだけ --%>
<%
List<RecipeDTO> list = (List<RecipeDTO>) request.getAttribute("recipeList");
for (RecipeDTO r : list) {
%>
    <p><%= r.getTitle() %></p>
<% } %>
```

### 間違い2: 閉じタグ忘れ

```jsp
<%-- NG: } を忘れている --%>
<% if (user != null) { %>
    <p>ログイン中</p>
<%-- } がない！ --%>

<%-- OK: 必ず閉じる --%>
<% if (user != null) { %>
    <p>ログイン中</p>
<% } %>
```

### 間違い3: HTMLの中でのJavaコード分断

```jsp
<%-- NG: 読みにくい --%>
<% if (user != null) { %><p>ようこそ<%= user.getUsername() %></p><% } %>

<%-- OK: 改行して見やすく --%>
<% if (user != null) { %>
    <p>ようこそ、<%= user.getUsername() %>さん</p>
<% } %>
```

### 間違い4: NullPointerException

```jsp
<%-- NG: nullチェックなし --%>
<p><%= recipe.getTitle() %></p>  <%-- recipeがnullだとエラー --%>

<%-- OK: nullチェックあり --%>
<% if (recipe != null) { %>
    <p><%= recipe.getTitle() %></p>
<% } else { %>
    <p>レシピが見つかりません</p>
<% } %>
```

---

## 実践例: レシピ詳細ページ

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.recipe.dto.RecipeDTO" %>
<%@ page import="jp.co.recipe.dto.UserDTO" %>
<%@ include file="../layout/header.jsp" %>

<%
// サーブレットから渡されたデータを取得
RecipeDTO recipe = (RecipeDTO) request.getAttribute("recipe");
%>

<div class="recipe-detail">
    <%-- タイトル --%>
    <h1><%= recipe.getTitle() %></h1>

    <%-- 画像（あれば表示） --%>
    <% if (recipe.getImageFilename() != null && !recipe.getImageFilename().isEmpty()) { %>
        <div class="recipe-image">
            <img src="<%= request.getContextPath() %>/uploads/<%= recipe.getImageFilename() %>"
                 alt="<%= recipe.getTitle() %>">
        </div>
    <% } %>

    <%-- 内容 --%>
    <div class="recipe-content">
        <%= recipe.getContent() %>
    </div>

    <%-- 投稿者情報 --%>
    <div class="recipe-meta">
        <p>投稿者:
            <a href="<%= request.getContextPath() %>/user/profile?id=<%= recipe.getAuthorId() %>">
                <%= recipe.getAuthorname() %>
            </a>
        </p>
        <p>投稿日: <%= recipe.getCreatedAt() %></p>
    </div>

    <%-- 編集・削除ボタン（自分の投稿のみ表示） --%>
    <% if (loginUser != null && recipe.getAuthorId() == loginUser.getId()) { %>
        <div class="recipe-actions">
            <a href="<%= request.getContextPath() %>/recipe/edit?id=<%= recipe.getId() %>"
               class="btn-edit">編集</a>
            <a href="<%= request.getContextPath() %>/recipe/delete?id=<%= recipe.getId() %>"
               class="btn-delete">削除</a>
        </div>
    <% } %>
</div>

<%@ include file="../layout/footer.jsp" %>
```

---

## ファイル配置

```
src/main/webapp/
├── views/
│   ├── jsp/                    ← メインのJSPファイル
│   │   ├── home.jsp
│   │   ├── login.jsp
│   │   ├── register.jsp
│   │   ├── recipeDetail.jsp
│   │   ├── recipeForm.jsp
│   │   └── userProfile.jsp
│   └── layout/                 ← 共通パーツ
│       ├── header.jsp
│       └── footer.jsp
├── css/
│   └── style.css
└── uploads/                    ← アップロード画像
```

---

## まとめ

| タグ | 用途 | 例 |
|------|------|-----|
| `<%= %>` | 値を出力 | `<%= user.getName() %>` |
| `<% %>` | Javaコード実行 | `<% if (x > 0) { %>` |
| `<%@ %>` | ページ設定 | `<%@ page import="..." %>` |
| `<%-- --%>` | コメント | `<%-- メモ --%>` |

### JSPの心得

1. **表示だけに徹する** - ロジックはサーブレットで
2. **nullチェックを忘れない** - NullPointerException防止
3. **コンテキストパスを使う** - 環境に依存しないパス
4. **共通部分は分離** - header.jsp, footer.jsp
5. **見やすく書く** - 適切な改行とインデント
