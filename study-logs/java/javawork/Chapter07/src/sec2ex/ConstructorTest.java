package sec2ex;

public class ConstructorTest {

	public static void main(String[] args) {
// インスタンス化
		Ex02 pc = new Ex02();
		String name = pc.name;
		int price = pc.price;
		name = "パソコン";
		price = 100000;
		
		System.out.println("商品名は"+ name+ "です");
		System.out.println("価格は"+ price+ "円です");
		
		
		name = "パソコン(旧モデル)";
		System.out.println("商品名は"+ name+ "です");
		pc.discount(price);
		
	}
}
