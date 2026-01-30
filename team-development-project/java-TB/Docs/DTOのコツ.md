# DTOのコツ

DTO（Data Transfer Object）は、データを運ぶための「箱」です。

---

## DTOの役割

```
┌─────────────────────────────────────────┐
│              DTO の役割                  │
│                                         │
│    「データを入れて運ぶだけの箱」         │
│                                         │
│    ✓ フィールド（変数）を持つ            │
│    ✓ getter/setterを持つ                │
│    ✗ ロジック（計算や判断）は書かない    │
│    ✗ データベース操作しない              │
└─────────────────────────────────────────┘
```

---

## データの流れ

```
データベース
    ↓ SELECT結果
   DAO
    ↓ DTOに詰める
   DTO ←←←←← データの箱
    ↓ サーブレットに渡す
 Servlet
    ↓ JSPに渡す
   JSP
    ↓ 画面に表示
 ブラウザ
```

---

## 基本的な構造

```java
package jp.co.recipe.dto;

public class RecipeDTO Serializable {
//Serializableを継承するとバイト化できる（データで送れるし保存できる）

    // ========== フィールド（テーブルのカラムに対応） ==========
    private int id;
    private String title;
    private String content;
    private int authorId;
    private String imageFilename;
    private java.sql.Timestamp createdAt;

    // DBにないけど表示用に使うフィールドもOK
    private String authorname;  // JOINで取得した投稿者名

    // ========== コンストラクタ ==========

    // 引数なしコンストラクタ（必須）
    public RecipeDTO() {
    }

    // 引数ありコンストラクタ（任意）
    public RecipeDTO(String title, String content, int authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    // ========== getter/setter ==========

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ... 他のフィールドも同様

    //tostringメソッドですべてのフィールド値を表示できるようにしておく
    @Override
    public String toString() {
	return "UserDTO{" +
			"id=" + id +
			", username='" + username + "'" +
			", email='" + email + "'" +
			", profileImage='" + profileImage + "'" +
			"}";
}
}
```

---

## getter/setterとは

### getter（取得するメソッド）

```java
// フィールドの値を返す
public String getTitle() {
    return title;
}

// 使い方
String t = recipe.getTitle();  // "チキンカレー"
```

### setter（設定するメソッド）

```java
// フィールドに値を設定する
public void setTitle(String title) {
    this.title = title;
}

// 使い方
recipe.setTitle("チキンカレー");
```

### 命名規則

```java
// フィールド名: title
// getter: getTitle()  ← get + Title（先頭大文字）
// setter: setTitle()  ← set + Title（先頭大文字）

// フィールド名: authorId
// getter: getAuthorId()
// setter: setAuthorId()

// boolean型の場合
// フィールド名: active
// getter: isActive()  ← is + Active
// setter: setActive()
```

---

## なぜgetter/setterを使うのか？

### 直接アクセスの問題

```java
// NG: フィールドをpublicにして直接アクセス
public class RecipeDTO {
    public String title;  // public
}

recipe.title = "";  // 空文字を設定できてしまう
recipe.title = null;  // nullも設定できてしまう
```

### getter/setterのメリット

```java
// OK: privateにしてgetter/setter経由
public class RecipeDTO {
    private String title;

    public void setTitle(String title) {
        // バリデーションを追加できる
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("タイトルは必須です");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
```

**実際には**、DTOはシンプルに保ち、バリデーションはサーブレットで行うことが多いです。

---

## テーブルとDTOの対応

### recipesテーブル

```sql
CREATE TABLE recipes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    author_id INT NOT NULL,
    image_filename VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
```

### RecipeDTO

```java
public class RecipeDTO {
    private int id;                    // id INT
    private String title;              // title VARCHAR(100)
    private String content;            // content TEXT
    private int authorId;              // author_id INT
    private String imageFilename;      // image_filename VARCHAR(255)
    private java.sql.Timestamp createdAt;  // created_at DATETIME

    // ※ DBにないフィールドを追加してもOK
    private String authorname;  // JOINで取得する投稿者名
}
```

### 型の対応表

| SQLの型 | Javaの型 |
|--------|---------|
| INT | int または Integer |
| VARCHAR, TEXT | String |
| DATETIME, TIMESTAMP | java.sql.Timestamp |
| DATE | java.sql.Date |
| DOUBLE | double または Double |
| BOOLEAN | boolean または Boolean |

---

## 実践例

### UserDTO

```java
package jp.co.recipe.dto;

public class UserDTO {

    private int id;
    private String username;
    private String password;
    private String email;
    private String profileImage;

    // 引数なしコンストラクタ
    public UserDTO() {
    }

    // 登録用コンストラクタ
    public UserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    @Override
    public String toString() {
	return "UserDTO{" +
			"id=" + id +
			", username='" + username + "'" +
			", email='" + email + "'" +
			", profileImage='" + profileImage + "'" +
			"}";
    }

}
```

### RecipeDTO

```java
package jp.co.recipe.dto;

import java.sql.Timestamp;

public class RecipeDTO {

    private int id;
    private String title;
    private String content;
    private int authorId;
    private String imageFilename;
    private Timestamp createdAt;

    // DB外のフィールド（JOIN用）
    private String authorname;

    // 引数なしコンストラクタ
    public RecipeDTO() {
    }

    // getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
    @Override
    public String toString() {
	return "RecipeDTO{" +
			"id=" + id +
			", title='" + title + "'" +
			", content='" + content + "'" +
			", authorname='" + authorname + "'" +
			", authorId=" + authorId +
			", createdAt=" + createdAt +
			", imageFilename='" + imageFilename + "'" +
			"}";
}

}
```

---

## DTOの使い方

### DAOで使う（データを詰める）

```java
// RecipeDAO.java
public RecipeDTO findById(int id) throws SQLException {
    String sql = "SELECT * FROM recipes WHERE id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // DTOを作成してデータを詰める
            RecipeDTO recipe = new RecipeDTO();
            recipe.setId(rs.getInt("id"));
            recipe.setTitle(rs.getString("title"));
            recipe.setContent(rs.getString("content"));
            recipe.setAuthorId(rs.getInt("author_id"));
            return recipe;
        }
    }
    return null;
}
```

### サーブレットで使う（受け渡し）

```java
// RecipeDetailServlet.java
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    RecipeDAO dao = new RecipeDAO(conn);
    RecipeDTO recipe = dao.findById(id);  // DAOからDTOを受け取る

    request.setAttribute("recipe", recipe);  // JSPに渡す
    request.getRequestDispatcher("/views/jsp/recipeDetail.jsp")
           .forward(request, response);
}
```

### JSPで使う（データを表示）

```jsp
<%
RecipeDTO recipe = (RecipeDTO) request.getAttribute("recipe");
%>

<h1><%= recipe.getTitle() %></h1>
<p><%= recipe.getContent() %></p>
```

### フォームからDTOを作成

```java
// RecipeCreateServlet.java
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // フォームの入力値を取得
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    // セッションからユーザーIDを取得
    HttpSession session = request.getSession();
    UserDTO user = (UserDTO) session.getAttribute("user");
    int authorId = user.getId();

    // DTOに詰める
    RecipeDTO recipe = new RecipeDTO();
    recipe.setTitle(title);
    recipe.setContent(content);
    recipe.setAuthorId(authorId);

    // DAOで登録
    RecipeDAO dao = new RecipeDAO(conn);
    dao.insert(recipe);
}
```

---

## Eclipseでgetter/setterを自動生成

毎回手で書くのは大変なので、自動生成機能を使いましょう。

### 手順

1. フィールドを書く
   ```java
   private int id;
   private String title;
   private String content;
   ```

2. 右クリック → **ソース** → **getter および setter の生成**

3. 生成するフィールドを選択 → **OK**

4. 自動でgetter/setterが追加される

---

## よくある間違いと対策

### 間違い1: 引数なしコンストラクタがない

```java
// NG: 引数ありコンストラクタだけ
public class RecipeDTO {
    public RecipeDTO(String title) {
        this.title = title;
    }
}

// DAOで new RecipeDTO() ができない！

// OK: 引数なしコンストラクタを追加
public class RecipeDTO {
    public RecipeDTO() {  // これが必要
    }

    public RecipeDTO(String title) {
        this.title = title;
    }
}
```

### 間違い2: getter/setterの名前が間違っている

```java
// NG: 命名規則が違う
public String title() { ... }      // getがない
public void Title(String t) { ... } // setがない

// OK: 正しい命名
public String getTitle() { ... }
public void setTitle(String title) { ... }
```

### 間違い3: フィールドとカラム名の不一致

```java
// DBカラム: author_id
// Javaフィールド: authorId（キャメルケース）

// DAOでの対応
recipe.setAuthorId(rs.getInt("author_id"));  // カラム名はスネークケース
```

---

## DTOとJavaBeansの関係

DTOは「JavaBeans」の規約に従っています。

### JavaBeansの条件

1. `public` クラスである
2. 引数なしの `public` コンストラクタがある
3. フィールドは `private`
4. `getter/setter` でアクセス

```java
// これはJavaBeans（= DTO）
public class RecipeDTO {
    private String title;

    public RecipeDTO() { }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
```

---

## まとめ

### DTOの心得

1. **シンプルに保つ** - フィールドとgetter/setterだけ
2. **ロジックは書かない** - 計算やバリデーションは別の場所で
3. **テーブルと対応させる** - 1テーブル1DTO が基本
4. **引数なしコンストラクタを忘れない** - DAOで使うため
5. **Eclipseの自動生成を活用** - 手打ちミスを防ぐ

### ファイル配置

```
src/main/java/jp/co/recipe/
└── dto/
    ├── RecipeDTO.java
    ├── UserDTO.java
    └── FavoriteDTO.java  （将来追加）
```
