package sec2ex;

public class Tea implements IDrink {
	@Override
	public void make() {
		System.out.println("紅茶を淹れます。");
	}
}
