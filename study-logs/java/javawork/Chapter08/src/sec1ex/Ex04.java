package sec1ex;

public class Ex04 {

	public static void main(String[] args) {
		ArbeitStaff abs = new ArbeitStaff("A", 1200);
		int sum = abs.getPayment(6);
		
		ArbeitStaff ab = new ArbeitStaff("B");
		sum += ab.getPayment(3, 4);
		
		System.out.println("アルバイト料の合計は"+ sum+ "です");
		
	}

}
