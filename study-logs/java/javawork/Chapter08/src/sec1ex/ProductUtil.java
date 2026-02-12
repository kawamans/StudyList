package sec1ex;

public class ProductUtil {
	public static final int MIN_PRICE = 1;
	
	public static boolean isValidPrice(int price) {
		boolean validResult = price >= MIN_PRICE;
		return validResult;
	}
}
