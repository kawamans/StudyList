package sec2;

public class Coffee implements IDrink {
	@Override
	public void make() {
		System.out.println("コーヒーを淹れます。");
	}
}
