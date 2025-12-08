package sec1ex;

public class OcerloadTest {

	public static void main(String[] args) {

		Product pc = new Product("パソコン", 100000);
		String name = pc.getName();
		int price = pc.getPrice();
		boolean advisavility = pc.isAdvisability();
		
		System.out.println("---商品情報---");
		System.out.println("名前："+ name);
		System.out.println("価格："+ price);
		System.out.println("可否："+ advisavility);
		
		pc.discount();
		price = pc.getPrice();
		
		System.out.println("---商品情報---");
		System.out.println("名前："+ name);
		System.out.println("価格："+ price);
		System.out.println("可否："+ advisavility);
		
		pc.discount(30000);
		price = pc.getPrice();
		
		System.out.println("---商品情報---");
		System.out.println("名前："+ name);
		System.out.println("価格："+ price);
		System.out.println("可否："+ advisavility);
		
	}
}