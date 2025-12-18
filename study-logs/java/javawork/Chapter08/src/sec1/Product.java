package sec1;

public class Product {
	
	private String name;
	private int price;
	private boolean advisability;
	
	public Product(String name) {
		this(name, 1);
	}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		this.advisability = true;
	}
	
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
	
	public void discount() {
		price *= 0.9;
	}
	
	public void discount(int value) {
		price -= value;
	}
	
}
