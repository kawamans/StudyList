package sec1ex;

public class Ex01 {

	public static void main(String[] args) {
		Product[] pcs = {
			new Computer("サンプルパソコンA", 200000),
			new Computer("パソコンA", 250000),
			new Computer("サンプルパソコンB", 180000),
			
			new Computer("パソコンB", 210000)
		};
		
		for (Product p : pcs) {
			System.out.println(p.name+ "："+ p.price+ "円");
		}
		
	}

}
