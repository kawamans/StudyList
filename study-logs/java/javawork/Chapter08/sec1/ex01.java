package sec1;

public class ex01 {
	public static void main(String[] args) {

		Product pc = new Product("パソコン", 100000);

		String name = pc.getName();
		int price = pc.getPrice();
		
		System.out.println("---商品情報---");
		System.out.println("名前："+ name);
		System.out.println("価格："+ price);
		System.out.println("可否："+ ProductUtil.isValidPrice(price));
		
		
	}
}
