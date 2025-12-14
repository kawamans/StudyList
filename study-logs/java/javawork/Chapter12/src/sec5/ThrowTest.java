package sec5;

public class ThrowTest {

	public static void main(String[] args) {
		double heght = 0;
		double weight = 58.5;
		Bmi bmi = new Bmi(heght, weight);
		System.out.println("BMI値：" + bmi.calcBmi());
	}

}
