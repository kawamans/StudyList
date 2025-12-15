package sec5ex;

public abstract class Animal {
	protected String name;
	protected String type;
	
	@Override
	public String toString() {
		return "私は、"+ name+ "です。\n名前は、"+ type+ "です。";
	}
}
