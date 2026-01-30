/**
 * Task2_1: 課題内容
 *
 * 本課題では、データ型・文字列の使い方を学んでいきましょう。
 * 問①から問⑧まであります。
 * 指定された型・値・変数名を守って記述してください。
 *
 */
public class Task2_1 {

    public static void main(String[] args) {

        // ①int型の hogeInt という名前の変数を宣言し、値「50」で初期化して下さい。
    		int hogeInt = 50;

        // ②変数 hogeInt を値「100」で上書きして下さい。
    		hogeInt = 100;
    		
        // ③Stringクラスの hogeString という名前の変数を宣言し、値「テスト」で初期化して下さい。
    		String hogeString = "テスト";
    		
        // ④変数 hogeString を値「合格」で上書きして下さい。
    		hogeString = "合格";
    		
        // ⑤下記の処理について、何をしているのかコメントを記入して下さい。
        // [ダブル型のhogeDoubleを値0.2で初期化]
        double hogeDouble = 0.2;

        // ⑥変数 hogeInt の値を表示させて下さい。
        System.out.println(hogeInt);
        
        // ⑦下記の処理について、何をしているのかコメントを記入して下さい。
        // [hogeStringを表示]
        System.out.println(hogeString);

        // ⑧変数 hogeDouble の値を表示させて下さい。
        System.out.println(hogeDouble);
    }
}
/* コンソール出力結果↓

100
合格
0.2

 */