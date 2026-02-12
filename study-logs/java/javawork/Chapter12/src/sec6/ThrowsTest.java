package sec6;

public class ThrowsTest {
	public static void main(String[] args) {
		double height = 0;
		double weight = 58.5;
		Bmi bmi = new Bmi(height, weight);
		try {
			System.out.println("BMI値:" + bmi.calcBMI());
		} catch (Exception ex) {
			System.out.println("エラーが発生しました");
		} finally {
			System.out.println("処理が完了しました");
		}
	}
}