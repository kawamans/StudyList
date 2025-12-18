package sec2;

public class CapsuleTest {

	public static void main(String[] args) {

		Product pc = new Product("パソコン", 100000);

		String name = pc.getName();
		int price = pc.getPrice();

		System.out.println("商品名は" + name + "、価格は" + price + "円");

		
		pc.setPrice(80000);
		price = pc.getPrice();

		System.out.println("商品名は" + name + "、価格は" + price + "円");

	}
}