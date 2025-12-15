public class MethodTest1 {
	public static void main(String[] args) {
		System.out.println("3教科の総合点数を計算する");
		examResult1();
		System.out.println("3教科の総合点数を計算する");
		examResult1();
		System.out.println("3教科の総合点数を計算する");
		examResult1();
	}
	// 総合点数計算、出力メソッド
	public static void examResult1() {
		int subjectA = 80;
		int subjectB = 60;
		int subjectC = 70;
		System.out.println("3教科合計：" + (subjectA + subjectB + subjectC) + "点");
	}
}