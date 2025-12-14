package sec1ex;

public class Color {
	public final String COLOR;
	
	public Color(String color) {
		this.COLOR = color;
	}
	
	public String getCOLOR() {
		return COLOR;
	}
	
	@Override
	public String toString() {
		return "Color[COLOR="+ COLOR+ "]";
	}
}
