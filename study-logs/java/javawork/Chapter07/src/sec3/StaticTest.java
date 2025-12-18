package sec3;

public class StaticTest {

	public static void main(String[] args) {

		Product pc = new Product("パソコン", 100000);

		String name = pc.getName();
		int price = pc.getPrice();
		boolean advisavility = pc.isAdvisability();
		
		System.out.println("---商品情報---");
		System.out.println("名前："+ name);
		System.out.println("価格："+ price);
		System.out.println("可否："+ advisavility);
		
		System.out.println("商品最低価格：" + ProductUtil.MIN_PRICE);
		System.out.println("商品価格チェック：" + ProductUtil.isValidPrice(price));
		
		if (ProductUtil.isValidPrice(price)) {
			System.out.println("最低価格以上です");
		} else {
			System.out.println("設定価格を見直してください");
		}
		
	}
}