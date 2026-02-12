package study;

/**
 * 3_4: 課題内容
 *
 * 本課題では、mainメソッド・インスタンス・メソッドの呼び出しの使い方を学んでいきましょう。
 * 課題範囲は以下のとおりです。
 *   Study.java: 問①
 *   Main.java: 問①から問②
 * 指定された値と変数名を守って記述してください。
 *
 */
public class Main {

    public static void main(String[] args) {

        // ① 以下のルールに従いAccountクラスのインスタンスを生成してください。
        // 「コンソール出力結果」の通りとなるよう、アカウント情報（名前、ID、パスワード）を渡して下さい。
        // 変数名:「account」
    		Account account = new Account("kawamitsu", 123, "hoge123");

        // ② ①のインスタンス変数より、アカウント情報をコンソール出力するメソッドを呼び出しなさい。
    		account.printAccountInfo();
    }

}

/* コンソール出力結果↓

ユーザー名・・・山田
ID・・・123
パスワード・・・abc123

 */
