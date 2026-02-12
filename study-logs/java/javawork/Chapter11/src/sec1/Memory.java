package sec1;

public class Memory{
	// フィールド
	private String name;
	private int price;
	// コンストラクタ
	public Memory(String name, int price) {
		this.name = name;
		this.price = price;
	}
	// メソッド
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Memory [name=" + name + ", price=" + price + "]";
	}
}