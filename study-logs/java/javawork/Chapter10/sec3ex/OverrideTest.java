package sec3ex;

public class OverrideTest {

	public static void main(String[] args) {
		CentralProcessingUnit cpu = new CentralProcessingUnit("Core i5", 50000);
		Memory memory = new Memory("DDR4", 20000);
		HardDiscDrive hdd = new HardDiscDrive("500GBハードディスク", 3000);
		
		Computer pc = new Computer("Basic PC", 30000, cpu, memory, hdd);
		Product product = new Product("sample product", 10000);
		
		pc.use();
		product.use();
	}

}
