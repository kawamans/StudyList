package sec1ex;

public class Ex02 {

	public static void main(String[] args) {
		Ticket[] tickets = {
				new Ticket("東京", "大阪", 5000),
				new ExpressTicket("東京", "大阪", 5000, 3500),
				new Ticket("東京", "名古屋", 4000),
				new ExpressTicket("東京", "名古屋", 4000, 2500)
		};
		
		for (Ticket row : tickets) {
			System.out.println(row);
		}
	}

}
