package sec2ex;

public class Ex03 {
	public static void main(String[] args) {
		int price = 120;
		int priceTax =  (int)Math.round(price * 1.08);
		
		System.out.println("価格"+price+"円(税込み"+priceTax+"円)");
	}
}
