package sec1ex;

public class ArbeitStaff {
	
	String name;
	private int payment;
	
	public ArbeitStaff(String name, int payment) {
		this.name = name;
		this.payment = payment;
	}
	
	public ArbeitStaff(String name) {
		this.payment = 1000;
	}
	
	public int getPayment(int dayHour) {
		int dayPay = this.payment * dayHour;
		return dayPay;
	}
	
	public int getPayment(int dayHour, int nightHour) {
		int dayPay = this.payment * dayHour;
		dayPay += (this.payment + 200) * nightHour;
		return dayPay;
	}
}
