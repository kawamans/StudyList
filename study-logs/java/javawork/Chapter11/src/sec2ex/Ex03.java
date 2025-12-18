package sec2ex;

public class Ex03 {

	public static void main(String[] args) {
		Salable[] sab = {
				new Item("パソコン",100000),
				new Item("プリンター",50000),
				new Item("マウス",5000),
				new Item100("鉛筆"),
				new Item100("消しゴム")
				};
		
		int sum = 0;
		for (Salable item : sab) {
			System.out.println(item.getName()+ "："+ item.getPrice()+ "円");
			sum += item.getPrice();
		}
		System.out.println("=================");
		System.out.println("商品総額は、"+ sum+ "円");
		
	}	

}
