import java.util.Scanner;

public class MethodTest4 {
	public static void main(String[] args) {
		// Scannerの用意
		Scanner scan = new Scanner(System.in);
		System.out.println("点数を入力してください-> ");
		System.out.print("科目Aの点数-> ");
		int subjectA = scan.nextInt();
		System.out.print("科目Bの点数-> ");
		int subjectB = scan.nextInt();
		System.out.print("科目Cの点数-> ");
		int subjectC = scan.nextInt();
		System.out.println("--------------------");
		System.out.println("3教科の総合点数、結果を表示する");
		int totalExamScore = examResult4(subjectA, subjectB, subjectC);
		System.out.println("3教科合計：" + totalExamScore + "点");
		System.out.println(judge(totalExamScore));
	}

	// 総合点数計算メソッド
	public static int examResult4(int subjectA, int subjectB, int subjectC) {
		return subjectA + subjectB + subjectC;
	}

	// 結果判定メソッド
	public static String judge(int totalExamScore) {
		if (totalExamScore >= 240) {
			return "合格です";
		} else if (totalExamScore >= 200) {
			return "再試験です";
		} else {
			return "補習と再試験です";
		}
	}
}