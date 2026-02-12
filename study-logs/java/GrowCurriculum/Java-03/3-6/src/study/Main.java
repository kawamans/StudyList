package study;

/**
 * 3_6 : 課題内容
 *
 * 本課題では、継承・オーバーロードメソッドの基本的な使い方を学んでいきましょう。
 * 課題は問①から問②まであります。
 * 指定された値と変数名を守って記述してください。
 *
 */
// ① MainクラスにCalculatorクラスを継承させなさい。
public class Main extends Calculator {

    public static void main(String[] args) {

        // ② Calculator.javaのオーバーロードメソッド「plus」に適当な引数を与えて全て表示させなさい。
        // 「コンソール出力結果」の通りとなるよう表示させて下さい。
    		System.out.println("plusメソッドの引数が1つ:" + Calculator.plus(10));
    		System.out.println("plusメソッドの引数が2つ:" + Calculator.plus(10 , 19));
    		System.out.println("plusメソッドの引数が3つ:" + Calculator.plus(10 + 19 + 30));
    }

}

/* コンソール出力結果↓

plusメソッドの引数が1つ:11
plusメソッドの引数が2つ:30
plusメソッドの引数が3つ:60

 */