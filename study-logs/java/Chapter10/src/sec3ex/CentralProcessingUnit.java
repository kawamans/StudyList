package sec3ex;

public class CentralProcessingUnit {
	private String name;
	private int price;
	
	public CentralProcessingUnit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
}
