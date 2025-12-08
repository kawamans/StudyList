package sec3ex;

public class Rensyu13 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;
		ICalculate[] calcs = {
				new Addition(),
				new Subtraction(),
				new Multiplication(),
				new Division()
		};
		
		for(ICalculate calc : calcs) {
			calc.setFields(num1, num2);
			Double ans = calc.calculate();
			
			if(ans == null) { 
				System.out.println("計算結果：" + calc + "計算できません");
			}else {
				System.out.println("計算結果：" + calc + ans);
			}
		}
	}
}
