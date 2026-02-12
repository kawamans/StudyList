# XSS対策について

XSS（Cross-Site Scripting）は、Webアプリケーションで最も多い脆弱性の一つです。
このドキュメントでは、本プロジェクトでのXSS対策方法を説明します。

---
  ## JSTLとスクリプトレットの対応表

  | JSTL | スクリプトレット |
  |:---|:---|
  | `<%@ taglib prefix="c" ...%>` | 不要（削除） |
  | `${meetingRoom.date}` | `<%= meetingRoom.getDate() %>` |
  | `<c:set var="x" value="${y}"/>` | `<% X x = y; %>` |
  | `<c:forEach var="item" items="${list}">` | `<% for (int i = 0; i < list.length; i++) { %>` |
  | `<c:choose>` | `<% if () { %>` |
  | `<c:when test="${condition}">` | `<% if (condition) { %>` |
  | `<c:otherwise>` | `<% } else { %>` |
  | `</c:forEach>` | `<% } %>` |
  ---
## XSSとは

```
XSS攻撃の流れ

攻撃者 → 悪意のあるスクリプトを入力
            ↓
サーバー → そのまま保存 or そのまま表示
            ↓
被害者 → ブラウザでスクリプトが実行される
            ↓
結果 → Cookie盗難、セッションハイジャック、画面改ざん
```

### 攻撃の例

ユーザーが入力フォームに以下を入力した場合：

```html
<script>alert('XSS攻撃!');</script>
```

対策していないと、このスクリプトが他のユーザーのブラウザで実行されてしまいます。

---

## XSS対策に必要なこと

**以下の2つを両方行う必要があります：**

| 対策 | 役割 | 必要性 |
|:---|:---|:---:|
| `<c:out>` でエスケープ | 根本的対策（スクリプトを無害化） | 必須 |
| Content-Typeでcharset指定 | 補助的対策（UTF-7攻撃などを防ぐ） | 必須 |

---

## よくある誤解

### 誤解1: 入力バリデーションで防げる

**入力バリデーションだけでは不十分！**

| 問題点 | 説明 |
|:---|:---|
| すり抜けのリスク | 攻撃パターンは無数にあり、すべてを入力時に検出するのは不可能 |
| 正当な入力を弾く | `<` や `>` が必要な場合もある（例：数式、技術文書） |
| 二重エンコードの問題 | 入力時にエスケープするとDBに `&lt;` が保存され、データが壊れる |
| 文脈依存 | HTML、JavaScript、URLなど、出力先によってエスケープ方法が異なる |

```
入力バリデーションの役割:

✗ XSS対策としては不十分
○ データ形式のチェック（長さ、型など）
○ 業務ロジックの検証
```

---

### 誤解2: EL式 `${}` で出力すれば安全

**${変数} はエスケープしない！そのまま出力される**

#### 危険な例

```jsp
<%-- これらはすべて危険！ --%>
<p>ようこそ、${userName}さん</p>
<p>会議室名: ${meetingRoom.name}</p>
<p>検索結果: ${param.keyword}</p>
```

もし `userName` に `<script>alert('XSS')</script>` が入っていたら、
そのままHTMLに出力され、スクリプトが実行されてしまいます。

#### スクリプトレット `<%= %>` も同様に危険

```jsp
<%-- これも危険！ --%>
<p>ようこそ、<%= request.getParameter("userName") %>さん</p>
```

---

### 誤解3: charsetを指定すればエスケープは不要

**charsetの指定だけでは不十分！エスケープ処理も必要**

charsetを指定しても、`<script>` などの危険な文字列はそのまま出力されます。

```jsp
<%-- JSPで出力 --%>
<p>${userName}</p>
```

もし `userName` が `<script>alert('XSS')</script>` だった場合：

| 設定 | 出力されるHTML | 結果 |
|:---|:---|:---|
| charset指定あり | `<p><script>alert('XSS')</script></p>` | スクリプト実行される |
| charset指定なし | `<p><script>alert('XSS')</script></p>` | スクリプト実行される |

**charsetを指定しても、エスケープ処理をしなければXSS攻撃は防げません。**

---

## 対策1：JSTLの `<c:out>` タグを使う（根本的対策）

### JSTLとは

JSTL（JavaServer Pages Standard Tag Library）は、JSPで使える標準タグライブラリです。
繰り返し処理、条件分岐、出力などをタグで簡単に書けます。

| タグ | 用途 |
|:---|:---|
| `<c:out>` | 値を出力する（エスケープ処理付き） |
| `<c:if>` | 条件分岐 |
| `<c:forEach>` | 繰り返し処理 |
| `<c:set>` | 変数に値を設定 |

### `<c:out>` タグとは

`<c:out>` は値を画面に出力するタグです。
**出力時に自動でHTMLエスケープ処理を行う**のが特徴です。

```jsp
<%-- 基本的な使い方 --%>
<c:out value="${変数名}" />

<%-- デフォルト値を指定（変数がnullの場合に表示） --%>
<c:out value="${変数名}" default="デフォルト値" />
```

### なぜ `<c:out>` を使うのか

`<c:out>` を使うと、危険な文字が自動的に無害な文字に変換されます。

| 入力値 | `${変数}` の出力 | `<c:out>` の出力 |
|:---|:---|:---|
| `<script>alert('XSS')</script>` | `<script>alert('XSS')</script>` | `&lt;script&gt;alert('XSS')&lt;/script&gt;` |
| 結果 | スクリプト実行される | ただの文字列として表示 |

### 使い方

#### 1. JSPの先頭でJSTLを読み込む

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

#### 2. 出力には必ず `<c:out>` を使う

```jsp
<%-- 安全：c:outが自動でエスケープしてくれる --%>
<p>ようこそ、<c:out value="${userName}" />さん</p>
<p>会議室名: <c:out value="${meetingRoom.name}" /></p>
<p>検索結果: <c:out value="${param.keyword}" /></p>
```

### 比較表

| 書き方 | 安全性 | 説明 |
|:---|:---:|:---|
| `${userName}` | ✗ 危険 | エスケープされない |
| `<%= userName %>` | ✗ 危険 | エスケープされない |
| `<c:out value="${userName}" />` | ○ 安全 | 自動でエスケープ |

### エスケープ対象の文字

| 文字 | エスケープ後 | 理由 |
|:---:|:---:|:---|
| `<` | `&lt;` | HTMLタグの開始を防ぐ |
| `>` | `&gt;` | HTMLタグの終了を防ぐ |
| `&` | `&amp;` | エスケープシーケンスの開始を防ぐ |
| `"` | `&quot;` | 属性値の終了を防ぐ |
| `'` | `&#39;` | 属性値の終了を防ぐ |

---

## 対策2：Content-Typeでcharsetを指定する（補助的対策）

**charsetを省略すると、UTF-7攻撃などを受ける可能性がある**

### なぜcharsetの指定が必要か

charsetを省略した場合、ブラウザは文字コードを独自に推定します。
攻撃者はこの挙動を悪用できます。

#### UTF-7攻撃の例

以下の文字列がHTMLに埋め込まれた場合：

```
+ADw-script+AD4-alert(+ACI-test+ACI-)+ADsAPA-/script+AD4-
```

一部のブラウザはこれをUTF-7として解釈し、以下のように処理します：

```html
<script>alert('test');</script>
```

エスケープ処理で `<` や `>` を対象にしていても、`+ADw-` などの文字列は
エスケープされないため、スクリプトが実行されてしまいます。

### 本プロジェクトでの対応

本プロジェクトの `EncodingFilter` でcharsetを設定しています：

```java
response.setCharacterEncoding("UTF-8");
```

JSPファイルでも必ず指定してください：

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
```

---

## JSPファイルの修正例

### 修正前（危険）

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
    <p>エラー: ${errorMessage}</p>
</body>
</html>
```

### 修正後（安全）

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
    <p>エラー: <c:out value="${errorMessage}" /></p>
</body>
</html>
```

---

## チェックリスト

JSPファイルを作成・修正するときは、以下を確認してください：

**エスケープ処理（根本的対策）**
- [ ] `<%@ taglib prefix="c" ...%>` を先頭に追加したか
- [ ] `${変数}` を `<c:out value="${変数}" />` に置き換えたか
- [ ] `<%= %>` を使っていないか（使っている場合は `<c:out>` に置き換え）
- [ ] `request.getParameter()` の値を直接出力していないか

**charset指定（補助的対策）**
- [ ] `<%@ page ... charset=UTF-8 %>` を指定しているか
- [ ] `<meta charset="UTF-8">` を指定しているか

---

## まとめ

**XSS対策の原則**

1. **入力バリデーションだけでは不十分**
   → 出力時のエスケープが必須

2. **EL式 ${} はエスケープしない**
   → そのまま使うとXSS脆弱性になる

3. **charsetの指定だけでも不十分**
   → エスケープ処理と両方必要

4. **`<c:out>` タグを使う（根本的対策）**
   → 自動でエスケープしてくれる

5. **Content-Typeでcharsetを指定する（補助的対策）**
   → UTF-7攻撃などを防ぐ

---

## 参考リンク

- [IPA 安全なウェブサイトの作り方](https://www.ipa.go.jp/security/vuln/websecurity.html)
- [OWASP XSS Prevention Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Cross_Site_Scripting_Prevention_Cheat_Sheet.html)
