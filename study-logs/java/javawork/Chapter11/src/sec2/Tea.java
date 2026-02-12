package sec2;

public class Tea implements IDrink {
	@Override
	public void make() {
		System.out.println("紅茶を淹れます。");
	}
}
