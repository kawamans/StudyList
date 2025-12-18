public class MethodTest3 {
	public static void main(String[] args) {
		System.out.println("3教科の総合点数、結果を表示する");
		System.out.println("3教科合計：" + examResult3() + "点");
		int totalExamScore = examResult3();
		if (totalExamScore >= 240) {
			System.out.println("合格です");
		} else if (totalExamScore >= 200) {
			System.out.println("再試験です");
		} else {
			System.out.println("補習、再試験です");
		}
	}

	// 総合点数計算メソッド
	public static int examResult3() {
		int subjectA = 80;
		int subjectB = 60;
		int subjectC = 70;
		return subjectA + subjectB + subjectC;
	}
}