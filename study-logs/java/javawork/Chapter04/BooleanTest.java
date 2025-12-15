import java.util.Scanner;

public class BooleanTest {
	public static void main(String[] args) {
		System.out.println("---処理開始---");
		// 論理値リテラル出力
		System.out.println("論理値リテラル：" + true);
		System.out.println("論理値リテラル：" + false);
		// Scannerの用意
		Scanner scan = new Scanner(System.in);
		System.out.println("キーボードから数字を入力してください-> ");
		System.out.print("1つ目の数字-> ");
		int i = scan.nextInt();
		System.out.print("2つ目の数字-> ");
		int j = scan.nextInt();
		// 比較演算子の結果出力
		System.out.println(" == " + (i == j));
		System.out.println(" != " + (i != j));
		System.out.println(" > " + (i > j));
		System.out.println(" < " + (i < j));
		System.out.println(" >= " + (i >= j));
		System.out.println(" <= " + (i <= j));
		// 論理演算子の結果出力
		System.out.println(" && " + (i > 0 && j > 0));
		System.out.println(" || " + (i > 0 || j > 0));
		boolean bool = !(i > 0 && j > 0);//論理演算結果を変数へ代入
		System.out.println(" ! " + bool);
		System.out.println("---処理終了---");
	}
}