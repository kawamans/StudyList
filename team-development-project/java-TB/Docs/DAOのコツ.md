# DAOのコツ

DAO（Data Access Object）は、データベースとのやり取りを専門に行うクラスです。

---

## DAOの役割

```
┌─────────────────────────────────────────┐
│              DAO の役割                  │
│                                         │
│    「データベース操作を一手に引き受ける」  │
│                                         │
│    ✓ SELECT, INSERT, UPDATE, DELETE     │
│    ✓ 結果をDTOに詰めて返す               │
│    ✗ 画面表示しない                      │
│    ✗ リクエスト処理しない                │
└─────────────────────────────────────────┘
```

---

## 基本的な構造

```java
package jp.co.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.recipe.dto.RecipeDTO;

public class RecipeDAO {

//	privateのコンストラクタにして、インスタンス化できなくする
//	staticメソッドをクラス名.で使う。
	
    private RecipeDAO() {
     
    }

    // ここにCRUDメソッドを書く
}
```

---

## CRUD操作の書き方

### CREATE（登録）

```java
/**
 * レシピを新規登録する
 * @param recipe 登録するレシピ情報
 * @return 成功したらtrue
 */
public static boolean insert(RecipeDTO recipe) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO recipes(title, content, author_id, image_filename)
        VALUES(?,?,?,?)";

        //ConnectionProviderクラスのgetConnectionメソッドでBD接続を取得
        try (Connection conn = ConnectionProvider.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recipe.getTitle());
            ps.setString(2, recipe.getContent());
            ps.setInt(3, recipe.getAuthorId());
            ps.setString(4, recipe.getImageFilename());
            int result = ps.executeUpdate(); //影響を受けた行数
            return result == 1; //1行追加された

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
```

### READ（取得）- 1件

```java
/**
 * IDでレシピを1件取得する
 * @param id レシピID
 * @return 見つかったレシピ、なければnull
 */
    public static RecipeDTO findById(int id) throws SQLException, ClassNotFoundException{

        String sql = "SELECT recipes.*, users.username " +
                     "FROM recipes " +
                     "JOIN users ON recipes.author_id = users.id " +
                     "WHERE recipes.id = ?";

        try (Connection conn = ConnectionProvider.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                RecipeDTO r = new RecipeDTO();
                r.setId(rs.getInt("id"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setAuthorId(rs.getInt("author_id"));
                r.setAuthorname(rs.getString("username"));  // ユーザー名を取得
                r.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                r.setImageFilename(rs.getString("image_filename"));
                return r;　//RecipeDTO型で返す
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

```

### READ（取得）- 複数件

```java
/**
 * 全レシピを取得する（新着順）
 * @return レシピのリスト
 */

//RecipeListは別クラスとして作成済み

 public static RecipeList findAll() throws SQLException, ClassNotFoundException {
    	
        RecipeList list = new RecipeList();

        // recipes テーブルと users テーブルを結合
        // recipes.author_id = users.id で紐づけ
        // users.username でユーザー名を取得
        String sql = "SELECT recipes.*, users.username " +
                     "FROM recipes " +
                     "JOIN users ON recipes.author_id = users.id " +
                     "ORDER BY recipes.created_at DESC";

        try (Connection conn = ConnectionProvider.getConnection();
            	PreparedStatement ps = conn.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RecipeDTO r = new RecipeDTO();
                r.setId(rs.getInt("id"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setAuthorId(rs.getInt("author_id"));
                r.setAuthorname(rs.getString("username"));  // ユーザー名を取得
                r.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                r.setImageFilename(rs.getString("image_filename"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;　//RecipeList型で返す
    }
```

### UPDATE（更新）

```java
/**
 * レシピを更新する
 * @param recipe 更新するレシピ情報（IDで特定）
 * @return 成功したらtrue
 */
    public static boolean edit(int id, String title, String content, String imageFilename) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE recipes SET title = ?, content = ?, image_filename = ? WHERE id = ?";
        try (Connection conn = ConnectionProvider.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, imageFilename);
            ps.setInt(4, id);
            int result = ps.executeUpdate();//更新された数
            return result; //1行変更

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

```

### DELETE（削除）

```java
/**
 * レシピを削除する
 * @param id 削除するレシピのID
 * @return 成功したらtrue
 */
    public static void delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM recipes WHERE id=?";
        try (Connection conn = ConnectionProvider.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

---

## よく使うパターン

### パターン1: 検索（LIKE句）

```java
/**
 * キーワードでレシピを検索する
 * @param keyword 検索キーワード
 * @return 該当するレシピのリスト
 */
    public static List<RecipeDTO> search(String keyword) throws SQLException, ClassNotFoundException {
        List<RecipeDTO> list = new ArrayList<>();
        String sql = "SELECT recipes.*, users.username " +
                     "FROM recipes " +
                     "JOIN users ON recipes.author_id = users.id " +
                     "WHERE recipes.title LIKE ? OR recipes.content LIKE ? " +
                     "ORDER BY recipes.created_at DESC";

        try (Connection conn = ConnectionProvider.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            String searchWord = "%" + keyword + "%";
            ps.setString(1, searchWord);
            ps.setString(2, searchWord);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RecipeDTO r = new RecipeDTO();
                r.setId(rs.getInt("id"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setAuthorId(rs.getInt("author_id"));
                r.setAuthorname(rs.getString("username"));  // ユーザー名を取得
                r.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                r.setImageFilename(rs.getString("image_filename"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
```

### パターン2: 特定ユーザーのデータ取得

```java
/**
 * 特定ユーザーのレシピを取得する
 * @param authorId ユーザーID
 * @return そのユーザーのレシピリスト
 */
    public static  List<RecipeDTO> findByAuthorId(int authorId) throws SQLException, ClassNotFoundException {
        List<RecipeDTO> list = new ArrayList<>();
        String sql = "SELECT recipes.*, users.username " +
                     "FROM recipes " +
                     "JOIN users ON recipes.author_id = users.id " +
                     "WHERE recipes.author_id = ? " +
                     "ORDER BY recipes.created_at DESC";

        try (Connection conn = ConnectionProvider.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, authorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RecipeDTO r = new RecipeDTO();
                r.setId(rs.getInt("id"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setAuthorId(rs.getInt("author_id"));
                r.setAuthorname(rs.getString("username"));
                r.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                r.setImageFilename(rs.getString("image_filename"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
```

### パターン3: 件数を取得

```java
/**
 * レシピの総数を取得する
 * @return 件数
 */
public int count() throws SQLException {
    String sql = "SELECT COUNT(*) FROM recipes";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    }
    return 0;
}
```

### パターン4: 存在チェック

```java
/**
 * 指定したIDのレシピが存在するか確認
 * @param id レシピID
 * @return 存在したらtrue
 */
public boolean exists(int id) throws SQLException {
    String sql = "SELECT 1 FROM recipes WHERE id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs.next();  // 結果があればtrue
    }
}
```

### パターン5: INSERT後のIDを取得

```java
/**
 * レシピを登録し、自動生成されたIDを返す
 * @param recipe 登録するレシピ
 * @return 生成されたID（失敗時は-1）
 */
public int insertAndGetId(RecipeDTO recipe) throws SQLException {
    String sql = "INSERT INTO recipes (title, content, author_id) VALUES (?, ?, ?)";

    try (PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, recipe.getTitle());
        ps.setString(2, recipe.getContent());
        ps.setInt(3, recipe.getAuthorId());

        ps.executeUpdate();

        // 自動生成されたキーを取得
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);  // 生成されたID
        }
    }
    return -1;
}
```

---

## PreparedStatementの重要性

### なぜPreparedStatementを使うのか？

```java
// ============ NG: SQLインジェクションの危険 ============
String keyword = request.getParameter("keyword");  // ユーザー入力
String sql = "SELECT * FROM recipes WHERE title = '" + keyword + "'";

// ユーザーが「' OR '1'='1」と入力すると...
// SELECT * FROM recipes WHERE title = '' OR '1'='1'
// → 全レシピが取得されてしまう！

// ============ OK: PreparedStatementで安全 ============
String sql = "SELECT * FROM recipes WHERE title = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, keyword);  // 自動でエスケープされる
```

### 型に応じたsetメソッド

```java
ps.setInt(1, 123);              // 整数
ps.setString(2, "文字列");       // 文字列
ps.setDouble(3, 3.14);          // 小数
ps.setBoolean(4, true);         // 真偽値
ps.setTimestamp(5, timestamp);  // 日時
ps.setNull(6, Types.VARCHAR);   // NULL
```

---

## try-with-resourcesの活用

```java
// ============ 古い書き方（冗長） ============
public RecipeDTO findById(int id) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        // ...
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
    }
}

// ============ 新しい書き方（推奨） ============
public RecipeDTO findById(int id) throws SQLException {
    String sql = "SELECT * FROM recipes WHERE id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        // ...
    }  // 自動でclose()される
}
```

---

## よくある間違いと対策

### 間違い1: SQLのスペルミス

```java
// NG: contentのスペルミス
String sql = "UPDATE recipes SET titl = ?, conente = ? WHERE id = ?";

// OK: 正しいカラム名
String sql = "UPDATE recipes SET title = ?, content = ? WHERE id = ?";
```

**対策**: SQLは別の場所（MySQL Workbenchなど）で先にテストする

### 間違い2: プレースホルダーの数が合わない

```java
// NG: ?が3つなのにsetが2つ
String sql = "INSERT INTO recipes (title, content, author_id) VALUES (?, ?, ?)";
ps.setString(1, title);
ps.setString(2, content);
// author_idのsetがない！

// OK: 全て揃っている
ps.setString(1, title);
ps.setString(2, content);
ps.setInt(3, authorId);
```

### 間違い3: ResultSetの取得順序

```java
// NG: カラム名を間違える
recipe.setTitle(rs.getString("name"));  // nameというカラムはない

// OK: 正しいカラム名
recipe.setTitle(rs.getString("title"));
```

### 間違い4: if と while の使い分け

```java
// 1件取得 → if
if (rs.next()) {
    // 1件だけ処理
}

// 複数件取得 → while
while (rs.next()) {
    // 繰り返し処理
}
```

---

## 命名規則

| メソッド名 | 用途 | 戻り値 |
|-----------|------|--------|
| `findById(int id)` | ID指定で1件取得 | DTO or null |
| `findAll()` | 全件取得 | List<DTO> |
| `findByXxx(...)` | 条件指定で取得 | List<DTO> |
| `insert(DTO)` | 新規登録 | boolean |
| `update(DTO)` | 更新 | boolean |
| `delete(int id)` | 削除 | boolean |
| `search(String keyword)` | 検索 | List<DTO> |
| `count()` | 件数取得 | int |
| `exists(int id)` | 存在確認 | boolean |

---

## 完成例: RecipeDAO

```java
package jp.co.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.recipe.dto.RecipeDTO;

public class RecipeDAO {

    private Connection conn;

    public RecipeDAO(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection is null");
        }
        this.conn = conn;
    }

    // 全件取得
    public List<RecipeDTO> findAll() throws SQLException {
        String sql = "SELECT recipes.*, users.username " +
                     "FROM recipes " +
                     "JOIN users ON recipes.author_id = users.id " +
                     "ORDER BY recipes.created_at DESC";

        List<RecipeDTO> list = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapToDTO(rs));
            }
        }
        return list;
    }

    // ID指定で1件取得
    public RecipeDTO findById(int id) throws SQLException {
        String sql = "SELECT recipes.*, users.username " +
                     "FROM recipes " +
                     "JOIN users ON recipes.author_id = users.id " +
                     "WHERE recipes.id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapToDTO(rs);
            }
        }
        return null;
    }

    // 新規登録
    public boolean insert(RecipeDTO recipe) throws SQLException {
        String sql = "INSERT INTO recipes (title, content, author_id, image_filename) " +
                     "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recipe.getTitle());
            ps.setString(2, recipe.getContent());
            ps.setInt(3, recipe.getAuthorId());
            ps.setString(4, recipe.getImageFilename());
            return ps.executeUpdate() == 1;
        }
    }

    // 更新
    public boolean update(RecipeDTO recipe) throws SQLException {
        String sql = "UPDATE recipes SET title = ?, content = ?, image_filename = ? " +
                     "WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recipe.getTitle());
            ps.setString(2, recipe.getContent());
            ps.setString(3, recipe.getImageFilename());
            ps.setInt(4, recipe.getId());
            return ps.executeUpdate() == 1;
        }
    }

    // 削除
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM recipes WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    // ResultSet → DTO 変換（共通処理）
    private RecipeDTO mapToDTO(ResultSet rs) throws SQLException {
        RecipeDTO recipe = new RecipeDTO();
        recipe.setId(rs.getInt("id"));
        recipe.setTitle(rs.getString("title"));
        recipe.setContent(rs.getString("content"));
        recipe.setAuthorId(rs.getInt("author_id"));
        recipe.setAuthorname(rs.getString("username"));
        recipe.setImageFilename(rs.getString("image_filename"));
        recipe.setCreatedAt(rs.getTimestamp("created_at"));
        return recipe;
    }
}
```

---

## まとめ

### DAOの心得


2. **SQLだけに集中** - 画面表示やリクエスト処理は書かない
3. **PreparedStatementを使う** - SQLインジェクション対策
4. **try-with-resourcesを使う** - リソースの自動解放
5. **共通処理はメソッド化** - mapToDTO()のように

### ファイル配置

```
src/main/java/jp/co/recipe/
└── dao/
    ├── RecipeDAO.java
    ├── UserDAO.java
    └── FavoriteDAO.java  （将来追加）
```
