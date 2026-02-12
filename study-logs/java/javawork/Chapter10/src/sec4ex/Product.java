package sec4ex;

public class Product {
	// フィールド
	// private String name;
	protected String name;
	// private int price;
	protected int price;
	// private boolean advisability;
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
	public void use() {
		System.out.println("商品を使用します");
	}
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
		return "商品名："+ name+ "\n価格："+ price;
	}
	
	
}