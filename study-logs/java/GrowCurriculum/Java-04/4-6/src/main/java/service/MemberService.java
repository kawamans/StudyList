package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.MemberBean;

/**
 * ・社員情報検索サービス
 *
 *
 */

public class MemberService {

    // 問① 接続情報を記述してください
    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee";
    /** ・ユーザー名 */
    private static final String USER = "postgres";
    /** ・パスワード */
    private static final String PASS = "postgres";
    /** ・タイムフォーマット */
    private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    // 問② 入力されたIDとPassWordをキーにして、ログインタイムをUPDATEする文
    /** ・SQL UPDATE文 */
    private static final String SQL_UPDATE = "UPDATE employee_table SET login_time = ? WHERE id = ? AND password = ?";

    // 問③ 入力されたIDとPassWordをキーにして、検索するSELECT文
    /** ・SQL SELECT文 */
    private static final String SQL_SELECT = "SELECT * FROM employee_table WHERE id = ? AND password = ?";

    MemberBean memberData = null;

    // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド
    public MemberBean search(String id, String password) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            // データベースに接続
            Class.forName(POSTGRES_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();

            // 処理が流れた時間をフォーマットに合わせて生成
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);

            // PreparedStatementで使用するため、String型に変換
            String login_time = sdFormat.format(cal.getTime());

            /*
             *  任意のユーザーのログインタイムを更新できるように、プリペアドステートメントを記述。
             */

            // preparedStatementに実行したいSQLを格納
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            // 問④ preparedStatementを使って、index1番目に今の時間、2番目にID、3番目にPASSWORDをセットしてください。
            preparedStatement.setString(1, login_time);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, password);
            
            // 問⑤ UPDATEを実行する文を記述して下さい。
            preparedStatement.executeUpdate();
            /*
             *  UPDATEが成功したものを即座に表示
             *  任意のユーザーを検索できるように、プリペアドステートメントを記述。
             */
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            //問⑥ index1番目にID、2番目にPASSWORDをセットしてください。
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);
            
            // SQLを実行。実行した結果をresultSetに格納。
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。
                String tmpName = resultSet.getString("name");
                String tmpComment = resultSet.getString("comment");
                String tmpLoginTime = resultSet.getString("login_time");

                // 問⑧ MemberBeanに取得したデータを入れてください。
                memberData = new MemberBean();
                memberData.setName(tmpName);
                memberData.setComment(tmpComment);
                memberData.setLogin_Time(tmpLoginTime);
            }

            // forName()で例外発生
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            // getConnection()、createStatement()、executeQuery()で例外発生
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return memberData;
    }
}
