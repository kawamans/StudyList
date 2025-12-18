package sec1ex;

public class ExpressTicket extends Ticket {
	protected int exp_add;
	
	public ExpressTicket(String from, String to, int fare, int exp_add) {
		super(from, to, fare);
		this.exp_add = exp_add;
	}
	
	@Override
	public int getFare() {
		this.fare += this.exp_add;
		return super.getFare();
	}
	
	@Override
	public String toString() {
		return super.toString()+"(特急乗車券)";
	}
}
