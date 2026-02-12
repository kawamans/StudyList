package sec1ex;

public abstract class Product { // abstract修飾子を指定
	// フィールド
	protected String name;
	protected int price;
	protected boolean advisability;
	
	// コンストラクタ
	public Product(String name) {
		this(name, 1);
	}
	// コンストラクタのオーバーロード
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		this.advisability = true;
	}
	// メソッド
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAdvisability() {
		return advisability;
	}
	public void setAdvisability(boolean advisability) {
		this.advisability = advisability;
	}
	//public void use () {
	// System.out.println("商品を使用します")
	//}
	public abstract void use(); // abstractを指定
	// 値下げメソッド
	public void discount() {
		price *= 0.9;
	}
	// 値下げメソッドのオーバーロード
	public void discount(int value) {
		price -= value;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", advisability=" + advisability + "]";
	}
}