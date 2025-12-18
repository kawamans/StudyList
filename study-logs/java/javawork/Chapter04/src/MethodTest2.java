import java.util.Scanner;

public class MethodTest2 {
	public static void main(String[] args) {
		// Scannerの用意
		Scanner scan = new Scanner(System.in);
		System.out.println("点数を入力してください");
		System.out.print("科目Aの点数-> ");
		int subjectA = scan.nextInt();
		System.out.print("科目Bの点数-> ");
		int subjectB = scan.nextInt();
		System.out.print("科目Cの点数-> ");
		int subjectC = scan.nextInt();
		System.out.println("--------------------");
		System.out.println("3教科の総合点数を計算する");
		examResult2(subjectA, subjectB, subjectC);
	}
	// 総合点数計算、出力メソッド
	public static void examResult2(int subjectA, int subjectB, int subjectC) {
		System.out.println("3教科合計：" + (subjectA + subjectB + subjectC) + "点");
	}
}