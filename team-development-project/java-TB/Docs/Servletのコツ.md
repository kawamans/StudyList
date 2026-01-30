# Servletのコツ

Servlet（サーブレット）は、リクエストを受け取って処理を行い、レスポンスを返す「司令塔」です。

---

## Servletの役割

```
┌─────────────────────────────────────────┐
│            Servlet の役割                │
│                                         │
│    「リクエストを受けて、処理して、返す」  │
│                                         │
│    ✓ リクエストパラメータを取得          │
│    ✓ DAOを呼んでデータ操作               │
│    ✓ JSPにデータを渡す                   │
│    ✓ リダイレクト/フォワード             │
│    ✗ HTML生成しない（JSPの仕事）         │
│    ✗ SQL実行しない（DAOの仕事）          │
└─────────────────────────────────────────┘
```

---

## 基本的な構造

```java
package jp.co.recipe.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")  // このURLでアクセス
public class HelloServlet extends HttpServlet {

    // GETリクエスト（ページ表示、リンククリック）
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 処理を書く
    }

    // POSTリクエスト（フォーム送信）
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 処理を書く
    }
}
```

---

## @WebServletの書き方

```java
// 単一のURL
@WebServlet("/home")

// 複数のURL
@WebServlet(urlPatterns = {"/recipe/new", "/recipe/create"})

// ワイルドカード
@WebServlet("/recipe/*")  // /recipe/xxx 全てにマッチ

// 名前付き（web.xmlと併用時）
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
```

---

## doGet と doPost の使い分け

### doGet - データの取得・表示

```java
// ページを表示する
// 検索結果を表示する
// 詳細情報を表示する

@WebServlet("/recipe/detail")
public class RecipeDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. パラメータを取得
        int id = Integer.parseInt(request.getParameter("id"));

        // 2. DAOでデータを取得
        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        RecipeDTO recipe = dao.findById(id);

        // 3. JSPにデータを渡す
        request.setAttribute("recipe", recipe);

        // 4. JSPにフォワード
        request.getRequestDispatcher("/views/jsp/recipeDetail.jsp")
               .forward(request, response);
    }
}
```

### doPost - データの登録・更新・削除

```java
// フォームを送信する
// ログインする
// データを登録する

@WebServlet("/recipe/create")
public class RecipeCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. フォームデータを取得
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // 2. DTOに詰める
        RecipeDTO recipe = new RecipeDTO();
        recipe.setTitle(title);
        recipe.setContent(content);

        // 3. DAOで登録
        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        dao.insert(recipe);

        // 4. 完了後にリダイレクト
        response.sendRedirect(request.getContextPath() + "/home");
    }
}
```

---

## フォワードとリダイレクトの使い分け

### フォワード（forward）

```java
// データを渡して画面を表示する
request.setAttribute("recipe", recipe);
request.getRequestDispatcher("/views/jsp/recipeDetail.jsp")
       .forward(request, response);
```

**特徴**:
- URLが変わらない
- request.setAttribute() で渡したデータが使える
- 1回のリクエストで完結

**使う場面**:
- 詳細ページの表示
- 検索結果の表示
- エラーメッセージの表示

### リダイレクト（redirect）

```java
// 別のURLに移動する
response.sendRedirect(request.getContextPath() + "/home");
```

**特徴**:
- URLが変わる
- request.setAttribute() のデータは消える
- ブラウザが新しいリクエストを送る

**使う場面**:
- 登録完了後にホームへ
- ログイン成功後にマイページへ
- 削除完了後に一覧へ

### 図で理解

```
【フォワード】
ブラウザ → Servlet → JSP → ブラウザ
              └─────→─────┘
           1回のリクエストで完結

【リダイレクト】
ブラウザ → Servlet → ブラウザ（302応答）→ 新しいURL → ブラウザ
                         └──────────→──────────┘
                         2回のリクエスト
```

---

## パラメータの取得

### GETパラメータ（URLの?以降）

```
URL: /recipe/detail?id=5&category=和食
```

```java
String id = request.getParameter("id");        // "5"
String category = request.getParameter("category");  // "和食"

// 数値に変換
int recipeId = Integer.parseInt(request.getParameter("id"));
```

### POSTパラメータ（フォームの入力値）

```html
<form action="LoginServlet" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">ログイン</button>
</form>
```

```java
String username = request.getParameter("username");
String password = request.getParameter("password");
```

### パラメータがない場合

```java
String keyword = request.getParameter("keyword");
// パラメータがないとnullが返る

// nullチェック
if (keyword != null && !keyword.isEmpty()) {
    // 検索処理
}
```

---

## セッションの操作

### ログイン時（セッションに保存）

```java
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO(conn);
        UserDTO user = dao.login(username, password);

        if (user != null) {
            // ログイン成功 → セッションに保存
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // ログイン失敗 → エラーメッセージ
            request.setAttribute("error", "ユーザー名かパスワードが違います");
            request.getRequestDispatcher("/views/jsp/login.jsp")
                   .forward(request, response);
        }
    }
}
```

### ログアウト時（セッションを破棄）

```java
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  // セッション破棄
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }
}
```

### セッションからユーザー情報を取得

```java
HttpSession session = request.getSession(false);  // なければnull

if (session != null && session.getAttribute("user") != null) {
    UserDTO user = (UserDTO) session.getAttribute("user");
    int userId = user.getId();
    String username = user.getUsername();
}
```

---

## 画像アップロード

### Servletの設定

```java
@WebServlet("/recipe/create")
@MultipartConfig(
    maxFileSize = 5242880,      // 5MB
    maxRequestSize = 10485760   // 10MB
)
public class RecipeCreateServlet extends HttpServlet {
```

### ファイルの受け取り

```java
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // テキストデータ
    String title = request.getParameter("title");

    // ファイルデータ
    Part filePart = request.getPart("image");  // <input type="file" name="image">

    if (filePart != null && filePart.getSize() > 0) {
        // ファイル名を取得
        String fileName = filePart.getSubmittedFileName();

        // ユニークなファイル名を生成
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;

        // 保存先のパス
        String uploadDir = getServletContext().getRealPath("/uploads");
        String filePath = uploadDir + File.separator + uniqueFileName;

        // ファイルを保存
        filePart.write(filePath);

        // DTOにファイル名を設定
        recipe.setImageFilename(uniqueFileName);
    }
}
```

---

## エラーハンドリング

### try-catchでエラーを捕捉

```java
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    try {
        int id = Integer.parseInt(request.getParameter("id"));

        RecipeDAO dao = new RecipeDAO(conn);
        RecipeDTO recipe = dao.findById(id);

        if (recipe == null) {
            // データが見つからない
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        request.setAttribute("recipe", recipe);
        request.getRequestDispatcher("/views/jsp/recipeDetail.jsp")
               .forward(request, response);

    } catch (NumberFormatException e) {
        // IDが数値でない
        response.sendRedirect(request.getContextPath() + "/home");

    } catch (SQLException e) {
        // データベースエラー
        e.printStackTrace();
        request.setAttribute("error", "エラーが発生しました");
        request.getRequestDispatcher("/views/jsp/error.jsp")
               .forward(request, response);
    }
}
```

---

## よく使うパターン

### パターン1: 一覧表示

```java
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        List<RecipeDTO> recipeList = dao.findAll();

        request.setAttribute("recipeList", recipeList);
        request.getRequestDispatcher("/views/jsp/home.jsp")
               .forward(request, response);
    }
}
```

### パターン2: 詳細表示

```java
@WebServlet("/recipe/detail")
public class RecipeDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        RecipeDTO recipe = dao.findById(id);

        if (recipe == null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        request.setAttribute("recipe", recipe);
        request.getRequestDispatcher("/views/jsp/recipeDetail.jsp")
               .forward(request, response);
    }
}
```

### パターン3: 登録（フォーム表示 + 登録処理）

```java
@WebServlet("/recipe/new")
public class RecipeCreateServlet extends HttpServlet {

    // フォーム表示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/views/jsp/recipeForm.jsp")
               .forward(request, response);
    }

    // 登録処理
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        RecipeDTO recipe = new RecipeDTO();
        recipe.setTitle(title);
        recipe.setContent(content);
        recipe.setAuthorId(user.getId());

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        dao.insert(recipe);

        response.sendRedirect(request.getContextPath() + "/home");
    }
}
```

### パターン4: 編集（フォーム表示 + 更新処理）

```java
@WebServlet("/recipe/edit")
public class RecipeEditServlet extends HttpServlet {

    // 編集フォーム表示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        RecipeDTO recipe = dao.findById(id);

        request.setAttribute("recipe", recipe);
        request.getRequestDispatcher("/views/jsp/recipeEdit.jsp")
               .forward(request, response);
    }

    // 更新処理
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        RecipeDTO recipe = new RecipeDTO();
        recipe.setId(id);
        recipe.setTitle(title);
        recipe.setContent(content);

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        dao.update(recipe);

        response.sendRedirect(request.getContextPath() + "/recipe/detail?id=" + id);
    }
}
```

### パターン5: 削除

```java
@WebServlet("/recipe/delete")
public class RecipeDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        dao.delete(id);

        response.sendRedirect(request.getContextPath() + "/home");
    }
}
```

### パターン6: 検索

```java
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        if (keyword == null || keyword.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
        RecipeDAO dao = new RecipeDAO(conn);
        List<RecipeDTO> recipeList = dao.search(keyword);

        request.setAttribute("keyword", keyword);
        request.setAttribute("recipeList", recipeList);
        request.getRequestDispatcher("/views/jsp/searchResult.jsp")
               .forward(request, response);
    }
}
```

---

## よくある間違いと対策

### 間違い1: フォワード後にreturnがない

```java
// NG: フォワード後も処理が続く
if (user == null) {
    request.getRequestDispatcher("/login.jsp").forward(request, response);
    // ここも実行されてしまう！
}
request.setAttribute("data", data);

// OK: returnで終了
if (user == null) {
    request.getRequestDispatcher("/login.jsp").forward(request, response);
    return;  // ここで終了
}
request.setAttribute("data", data);
```

### 間違い2: getServletContext()とgetContextPath()の混同

```java
// getServletContext() - サーバー上のリソース取得
Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
String realPath = getServletContext().getRealPath("/uploads");

// getContextPath() - URLのコンテキストパス（/recipe など）
response.sendRedirect(request.getContextPath() + "/home");
```

### 間違い3: NumberFormatException

```java
// NG: パラメータがnullや空文字だとエラー
int id = Integer.parseInt(request.getParameter("id"));

// OK: チェックしてから変換
String idStr = request.getParameter("id");
if (idStr == null || idStr.isEmpty()) {
    response.sendRedirect(request.getContextPath() + "/home");
    return;
}
int id = Integer.parseInt(idStr);
```

---

## まとめ

### Servletの心得

1. **司令塔に徹する** - 処理の振り分けだけ
2. **doGetは表示、doPostは処理** - 役割を明確に
3. **フォワードとリダイレクトを使い分ける**
4. **エラーハンドリングを忘れない**
5. **return を忘れない** - フォワード/リダイレクト後

### 処理の流れ

```
doGet（表示系）:
パラメータ取得 → DAO呼び出し → setAttribute → フォワード

doPost（処理系）:
パラメータ取得 → DTO作成 → DAO呼び出し → リダイレクト
```

### ファイル配置

```
src/main/java/jp/co/recipe/
└── controller/
    ├── HomeServlet.java
    ├── LoginServlet.java
    ├── LogoutServlet.java
    ├── RecipeDetailServlet.java
    ├── RecipeCreateServlet.java
    ├── RecipeEditServlet.java
    ├── RecipeDeleteServlet.java
    ├── SearchServlet.java
    └── UserProfileServlet.java
```
