package sec5;

public class CentralProcessingUnit {
	// フィールド
	private String name;
	private int price;
	// コンストラクタ
	public CentralProcessingUnit(String name, int price) {
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
		return "CentralProcessingUnit [name=" + name + ", price=" + price + "]";
	}
}