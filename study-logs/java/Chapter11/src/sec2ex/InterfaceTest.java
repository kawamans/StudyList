package sec2ex;

public class InterfaceTest {

	public static void main(String[] args) {
		IDrink[] drinks = {new Coffee(), new Tea()};
		
		for(int i = 0; i < drinks.length; i++) {
			drinks[i].make();
		}

	}
}
