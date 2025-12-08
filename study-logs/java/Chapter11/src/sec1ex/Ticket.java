package sec1ex;

public class Ticket {
	protected String from;
	protected String to;
	protected int fare;
	
	public Ticket(String from, String to, int fare) {
		this.from = from;
		this.to = to;
		this.fare = fare;
	}
	
	public int getFare() {
		return fare;
	}
	
	@Override
	public String toString() {
		return from+ "→"+ to+ "："+ getFare()+ "円";
	}


}
