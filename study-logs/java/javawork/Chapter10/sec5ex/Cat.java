package sec5ex;

public class Cat extends Animal {
	
	public Cat(String type) {
		this.type = type;
		this.name = "まだない";
	}
	
	public Cat(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public void bark() {
		System.out.println("にゃーにゃー");
	}
	
	@Override
	public String toString() {
		return "吾輩は、"+ type+ "である。\n名前は、"+ name;
	}
}
