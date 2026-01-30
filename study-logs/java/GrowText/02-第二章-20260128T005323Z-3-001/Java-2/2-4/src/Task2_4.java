/**
 * Task2_4: 課題内容
 *
 * ログインする時のフォーム入力値について正しいものか判定するプログラムを想定しています。
 * サイトなどのログイン判定は、正しい値がデータベースに登録してあり、
 * それとログインフォームの入力値が一致するかを調べています。
 * 説明をよく読んで回答して下さい。
 *
 */
public class Task2_4 {

    // 定数（条件）
    // ① 任意の値を、｢CONST_NAMEにはString型｣、｢CONST_PASSにはint型｣で設定してください
    // Webサイトの新規ユーザー登録を行い、データベースに保存される正しいログインname、passのイメージとなります。
    private static final String CONST_NAME = ;
    private static final int CONST_PASS = ;

    // 定数（メッセージ）
    private static final String CONST_MSG_PRINT1 = "正しいログイン用name･passは下記となります。";
    private static final String CONST_MSG_PRINT2 = "フォームに入力されたname･passは下記となります。";
    private static final String CONST_MSG_SUCCESS = "ログイン成功です。";
    private static final String CONST_MSG_ERROR_NAME = "名前に誤りがあります。";
    private static final String CONST_MSG_ERROR_PASS = "パスワードに誤りがあります。";
    private static final String CONST_MSG_ERROR_INPUT = "入力情報に誤りがあります。";

    // 補足:
    //   定数はmain内で使用するために定義しています。
    //   finalという修飾子を付与すると、変数（動的に変わる値）ではなく、定数（変更不可な定まった値）となります。
    //   CONST_NAME 等が定数名となり、変数と同じように値の参照を行えます。

    public static void main(String[] args) {

        // ②任意の値を、以下の変数nameとpassに設定してください
        // この値は、ログインフォームに入力した値を想定したものとなります。
        String name = ;
        int pass = ;

        // 定数･変数の内容出力
        System.out.println(CONST_MSG_PRINT1);
        System.out.println("CONST_NAMEの値:" + CONST_NAME);
        System.out.println("CONST_PASSの値:" + CONST_PASS);
        System.out.println();
        System.out.println(CONST_MSG_PRINT2);
        System.out.println("nameの値:" + name);
        System.out.println("passの値:" + pass);
        System.out.println();


        // ③定数CONST_NAMEとCONST_PASS、変数nameとpassを使って、以下の条件を満たす条件分岐を記述して下さい。
        // 出力するメッセージは、設定済み定数を使用してください

        // フォームに入力した名前とパスワードが両方正しい時、「 ログイン成功です 」と出力する。
        // フォームに入力した名前のみ正しい場合、「 パスワードに誤りがあります。 」と出力する。
        // フォームに入力したパスワードのみ正しい場合、「 名前に誤りがあります。 」と出力する。
        // 名前もパスワードも間違っていた場合は、「 入力情報に誤りがあります。 」と出力する。
        


        // 補足:
        // 変数nameとpassの値を、定数と一致するものや間違ったものに変更し、再度実行を行うと、
        // 出力結果が変わるはずです。
        // 想定通りの条件分岐が行われるか、何度か試してみて下さい。

    }

}

/* コンソール出力結果↓

正しいログイン用name･passは下記となります。
CONST_NAMEの値:yamada
CONST_PASSの値:1234

フォームに入力されたname･passは下記となります。
nameの値:yamada
passの値:1234

ログイン成功です。(※定数メッセージの中からどれか1文が出力される)

 */