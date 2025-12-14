package sec4ex;

public class Ex02 {
	public static void main(String[] args) {
		Product[] pc = { 
			new Product("パソコン", 100000),
			new Product("テレビ", 50000), new Product("キーボード", 10000),
			new Product("マウス", 5000), new Product("スマホ", 150000)
		};
		
		for (Product pcs : pc) {
			System.out.println(pcs);
		}
		
	}
}
