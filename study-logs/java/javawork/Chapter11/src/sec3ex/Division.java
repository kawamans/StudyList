package sec3ex;

public class Division implements ICalculate {
	protected double num1;
	protected double num2;
	protected Double answer = null;
	
	@Override
	public Double calculate() {
		if (num2 <= 0 || num2 == 0) {
			return this.answer;
		} else {
			this.answer = this.num1 / this.num2;
			return this.answer;
		}
	}
	
	@Override
	public void setFields(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	@Override
	public String toString() {
		return num1+ "÷"+ num2+ "=";
	}
}
