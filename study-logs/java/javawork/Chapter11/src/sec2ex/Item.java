package sec2ex;

public class Item implements Salable {
	String name;
	int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getPrice() {
		return this.price;
	}
}
