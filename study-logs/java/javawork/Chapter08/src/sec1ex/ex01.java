package sec1ex;

public class ex01 {
	public static void main(String[] args) {

		Product pc = new Product("ボールペン", 200);
		String name = pc.getName();
		int price = pc.getPrice();
		
		pc.discount();
		price = pc.getPrice();
				
		System.out.println("商品名："+ name+ " 価格："+ price+ "円");
		
		pc.setName("未定");
		name = pc.getName();
		pc.setPrice(500);
		pc.discount(150);
		price = pc.getPrice();
		
		System.out.println("商品名："+ name+ " 価格："+ price+ "円");
	}
}
