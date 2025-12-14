package sec1ex;

public class ToyCar extends Product {
	private Color color;
	
	public ToyCar(String name, int price, Color color) {
		super(name, price);
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	@Override
	public void use() {
		System.out.println("おもちゃのくるまを使用します");
	}
	
	@Override
	public String toString() {
		return super.toString()+ "\nToyCar[color="+ color+ "]";
	}
}
