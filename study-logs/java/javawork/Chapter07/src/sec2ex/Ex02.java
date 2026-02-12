package sec2ex;

public class Ex02 {
	
	String name;
	int price;
	
	public void discount(int num) {
		double num2 = num*0.9;
		this.price = (int)num2;
		System.out.println("価格は"+ price+"円です");
	}

}
