package sec1;

public class Product {
	
//	フィールド
	String name;
		// name、文字列を格納するフィールド
	int price;
		// price、整数を格納するフィールド
	
// コンストラクタ
	public Product(String n) {
		this.name = n;
		this.price = 10000;
	}
	
//	メソッド
	void use() {
		System.out.println("商品を使用します");
			//	printする機能
	}
}
