package sec1ex;

public class PolymorphismTest {

	public static void main(String[] args) {
		Product[] productList = new Product[2];
		CentralProcessingUnit cpu = new CentralProcessingUnit("core i5", 50000);
		Memory memory = new Memory("DDR4", 20000);
		HardDiskDrive hdd = new HardDiskDrive("500GBハードディスク", 3000);
		Computer pc = new Computer("Basic PC", 30000, cpu, memory, hdd);
		Color color = new Color("BLUE");
		ToyCar toycar = new ToyCar("おもちゃのとらっく", 1500, color);
		
		productList[0] = pc;
		productList[1] = toycar;
		
		for (Product product : productList) {
			System.out.println(product);
			System.out.println("----------");
		}
	}

}
