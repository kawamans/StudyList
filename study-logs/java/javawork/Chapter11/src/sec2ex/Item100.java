package sec2ex;

public class Item100 implements Salable {
	protected String name;
	
	public Item100(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getPrice() {
		return 100;
	}
	
}
