package sec7;

public class OriginalExceptionTest2 {
	public static void main(String[] args) {
		double height = 0;
		double weight = 0;
		Bmi bmi = new Bmi(height, weight);
		try {
			System.out.println("BMI値:" + bmi.calcBMI());
		} catch (InputDataException ex) {
			System.out.println("独自例外でキャッチ");
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println("処理が完了しました");
		}
		
	}
}