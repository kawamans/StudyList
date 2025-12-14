package sec1;

public class InstanceTest {

	public static void main(String[] args) {
// インスタンス化
		Product pc = new Product("パーソナルコンピューター");
		
		pc.price = 100000;
		String name = pc.name;
		int price = pc.price;
		
		System.out.println("商品名は"+ name+ "、価格は"+ price+ "円");
		
		price = pc.price = 80000;
		System.out.println("商品名は"+ name+ "、価格は"+ price+ "円");
		
		pc.use();
	}
}
