# JSP・サーブレット・DAO・DTOの処理の流れ

Webアプリケーションにおけるデータの流れを説明します。

---

## 全体像

```
┌─────────────────────────────────────────────────────────────────┐
│                         ブラウザ                                 │
└─────────────────────────────────────────────────────────────────┘
                    ↓ リクエスト          ↑ レスポンス（HTML）
┌─────────────────────────────────────────────────────────────────┐
│                      JSP（View）                                 │
│                   画面の表示を担当                               │
└─────────────────────────────────────────────────────────────────┘
                    ↓ フォーム送信         ↑ データを渡す
┌─────────────────────────────────────────────────────────────────┐
│                  Servlet（Controller）                          │
│               リクエストを受け取り、処理を振り分け               │
└─────────────────────────────────────────────────────────────────┘
                    ↓ データ操作依頼       ↑ 結果を返す
┌─────────────────────────────────────────────────────────────────┐
│                    DAO（Model）                                  │
│              データベースとのやり取りを担当                      │
└─────────────────────────────────────────────────────────────────┘
                    ↓ SQL実行             ↑ 結果セット
┌─────────────────────────────────────────────────────────────────┐
│                   データベース                                   │
└─────────────────────────────────────────────────────────────────┘

※ DTO はデータを運ぶ「箱」として各層の間を行き来する
```

---

## 各コンポーネントの役割

### JSP（JavaServer Pages）

**役割**: 画面の表示（View）

```jsp
<%-- recipeDetail.jsp --%>
<%
RecipeDTO recipe = (RecipeDTO) request.getAttribute("recipe");
%>

<h1><%= recipe.getTitle() %></h1>
<p><%= recipe.getContent() %></p>
```

**ポイント**:
- HTMLの中にJavaコードを埋め込める
- サーブレットから渡されたデータを表示する
- ロジック（計算や判断）は書かない、表示だけ

---

### Servlet（サーブレット）

**役割**: リクエストの処理と振り分け（Controller）

```java
@WebServlet("/recipe/detail")
public class RecipeDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. リクエストからパラメータを取得
        int id = Integer.parseInt(request.getParameter("id"));

        // 2. DAOを使ってデータを取得
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

**ポイント**:
- URLとJavaクラスを紐づける（`@WebServlet`）
- `doGet`: GETリクエスト（ページ表示、検索など）
- `doPost`: POSTリクエスト（フォーム送信、データ登録など）
- DAOを呼び出してデータを取得/更新
- JSPにデータを渡して画面表示を依頼

---

### DAO（Data Access Object）

**役割**: データベース操作（Model）

```java
public class RecipeDAO {
    private Connection conn;

    public RecipeDAO(Connection conn) {
        this.conn = conn;
    }

    // レシピを1件取得
    public RecipeDTO findById(int id) throws SQLException {
        String sql = "SELECT * FROM recipes WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                RecipeDTO recipe = new RecipeDTO();
                recipe.setId(rs.getInt("id"));
                recipe.setTitle(rs.getString("title"));
                recipe.setContent(rs.getString("content"));
                return recipe;
            }
        }
        return null;
    }

    // レシピを登録
    public boolean insert(RecipeDTO recipe) throws SQLException {
        String sql = "INSERT INTO recipes (title, content, author_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recipe.getTitle());
            ps.setString(2, recipe.getContent());
            ps.setInt(3, recipe.getAuthorId());
            return ps.executeUpdate() == 1;
        }
    }
}
```

**ポイント**:
- 1テーブルにつき1つのDAOを作る（RecipeDAO, UserDAOなど）
- SQLを実行してデータを取得/更新/削除
- 結果をDTOに詰めて返す
- サーブレットからしか呼ばない（JSPから直接呼ばない）

---

### DTO（Data Transfer Object）

**役割**: データを運ぶ箱

```java
public class RecipeDTO {
    private int id;
    private String title;
    private String content;
    private int authorId;

    // ゲッター
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public int getAuthorId() { return authorId; }

    // セッター
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }
}
```

**ポイント**:
- フィールド（変数）とgetter/setterだけ
- ロジックは書かない
- テーブルのカラムと対応させる
- 各層の間でデータを受け渡すために使う

---

## 処理の流れ（具体例）

### 例1: レシピ詳細を表示する

```
1. ブラウザ: /recipe/detail?id=5 にアクセス
       ↓
2. RecipeDetailServlet (doGet)
   - request.getParameter("id") で 5 を取得
   - RecipeDAO.findById(5) を呼ぶ
       ↓
3. RecipeDAO
   - SELECT * FROM recipes WHERE id = 5 を実行
   - 結果を RecipeDTO に詰めて返す
       ↓
4. RecipeDetailServlet
   - request.setAttribute("recipe", recipe)
   - recipeDetail.jsp にフォワード
       ↓
5. recipeDetail.jsp
   - request.getAttribute("recipe") でDTOを取得
   - recipe.getTitle() などで表示
       ↓
6. ブラウザ: HTMLが表示される
```

---

### 例2: 新しいレシピを投稿する

```
1. ブラウザ: recipeForm.jsp でフォーム入力 → 送信
       ↓
2. RecipeCreateServlet (doPost)
   - request.getParameter("title") などで入力値を取得
   - RecipeDTO に詰める
   - RecipeDAO.insert(recipe) を呼ぶ
       ↓
3. RecipeDAO
   - INSERT INTO recipes ... を実行
   - 成功したら true を返す
       ↓
4. RecipeCreateServlet
   - 成功: ホームにリダイレクト
   - 失敗: エラーメッセージを表示
       ↓
5. ブラウザ: ホーム画面が表示される
```

---

## コツとベストプラクティス

### 1. 責任を分離する

| コンポーネント | やること | やらないこと |
|--------------|---------|-------------|
| JSP | 表示だけ | SQL、ビジネスロジック |
| Servlet | リクエスト処理、振り分け | SQL、HTML生成 |
| DAO | データベース操作だけ | 画面表示、リクエスト処理 |
| DTO | データを保持するだけ | ロジック |

### 2. エラーハンドリング

```java
// Servlet内
try {
    RecipeDTO recipe = dao.findById(id);
    if (recipe == null) {
        // 見つからない場合
        response.sendRedirect(request.getContextPath() + "/home");
        return;
    }
    request.setAttribute("recipe", recipe);
    request.getRequestDispatcher("/views/jsp/recipeDetail.jsp").forward(request, response);
} catch (SQLException e) {
    e.printStackTrace();
    // エラーページへ
    response.sendRedirect(request.getContextPath() + "/error");
}
```

### 3. フォワードとリダイレクトの使い分け

```java
// フォワード: データを渡して表示（URLは変わらない）
request.setAttribute("data", data);
request.getRequestDispatcher("/page.jsp").forward(request, response);

// リダイレクト: 別のURLに移動（URLが変わる）
response.sendRedirect(request.getContextPath() + "/home");
```

**使い分け**:
- **フォワード**: データを表示したい時（詳細ページ、検索結果など）
- **リダイレクト**: 処理完了後に別ページへ飛ばす時（登録完了後など）

### 4. PreparedStatementを使う

```java
// NG: SQLインジェクションの危険
String sql = "SELECT * FROM users WHERE id = " + id;

// OK: PreparedStatementで安全
String sql = "SELECT * FROM users WHERE id = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, id);
```

---

## JavaBeansを使う場面

### JavaBeansとは

以下の条件を満たすJavaクラス：
- 引数なしのコンストラクタがある
- フィールドはprivate
- getter/setterでアクセス

**→ DTOはJavaBeansの一種！**

### JSPでJavaBeansを使う（jsp:useBean）

```jsp
<%-- 従来の書き方 --%>
<%
RecipeDTO recipe = (RecipeDTO) request.getAttribute("recipe");
%>
<p><%= recipe.getTitle() %></p>

<%-- JavaBeans（jsp:useBean）を使う書き方 --%>
<jsp:useBean id="recipe" class="jp.co.recipe.dto.RecipeDTO" scope="request" />
<p><jsp:getProperty name="recipe" property="title" /></p>
```

### いつ使うか？

| 方法 | メリット | デメリット |
|------|---------|-----------|
| `<%= %>` | シンプル、柔軟 | Javaコードが混在 |
| `jsp:useBean` | JSPタグだけで書ける | 記述が長い |
| EL式 `${}` | 最もシンプル | 設定が必要な場合あり |

**現実的な使い分け**:

```jsp
<%-- 実務ではEL式が主流 --%>
<p>${recipe.title}</p>
<p>${recipe.content}</p>

<%-- 条件分岐はJSTLと組み合わせ --%>
<c:if test="${recipe.imageFilename != null}">
    <img src="${pageContext.request.contextPath}/uploads/${recipe.imageFilename}">
</c:if>
```

### jsp:useBeanが有効な場面

1. **フォームとDTOを自動バインド**

```jsp
<%-- フォームの入力値を自動でDTOに詰める --%>
<jsp:useBean id="user" class="jp.co.recipe.dto.UserDTO" scope="request" />
<jsp:setProperty name="user" property="*" />

<%-- これで user.getUsername() などにフォームの値が入る --%>
```

2. **JSPだけで完結する小さな処理**

ただし、現代のWebアプリではサーブレットで処理するのが一般的。

---

## まとめ

### 新機能を追加する手順

1. **テーブル設計**: 必要なカラムを決める
2. **DTO作成**: テーブルに対応するDTOを作る
3. **DAO作成**: CRUD操作のメソッドを作る
4. **Servlet作成**: リクエストを受けてDAOを呼ぶ
5. **JSP作成**: データを表示する画面を作る
6. **動作確認**: ブラウザでテスト

### ファイル配置

```
src/main/java/jp/co/recipe/
├── controller/          ← Servlet
│   ├── HomeServlet.java
│   ├── RecipeDetailServlet.java
│   └── LoginServlet.java
├── dao/                 ← DAO
│   ├── RecipeDAO.java
│   └── UserDAO.java
├── dto/                 ← DTO
│   ├── RecipeDTO.java
│   └── UserDTO.java
├── filter/              ← フィルター
│   └── EncodingFilter.java
└── listener/            ← リスナー
    └── DBInitListener.java

src/main/webapp/
├── views/jsp/           ← JSP（画面）
│   ├── home.jsp
│   ├── recipeDetail.jsp
│   └── login.jsp
├── css/                 ← スタイル
│   └── style.css
└── uploads/             ← アップロード画像
```
