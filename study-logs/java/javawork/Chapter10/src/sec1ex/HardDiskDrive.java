package sec1ex;

public class HardDiskDrive {
	// フィールド
	private String name;
	private int price;

	// コンストラクタ
	public HardDiskDrive(String name, int price) {
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
}