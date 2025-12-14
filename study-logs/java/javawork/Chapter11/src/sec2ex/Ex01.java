package sec2ex;

public class Ex01 {
	public static void main(String[] args) {
		Salable[] sab = {
				new Item("パソコン",100000),
				new Item("プリンター",50000),
				new Item("マウス",5000)
				};
		
		int sum = 0;
		for (Salable sabs : sab) {
			sum += sabs.getPrice();
		}
		System.out.println("商品総額は、"+ sum+ "円");
	}
}
