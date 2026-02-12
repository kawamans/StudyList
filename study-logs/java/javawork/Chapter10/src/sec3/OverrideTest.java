package sec3;

public class OverrideTest {
	public static void main(String[] args) {
		// コンピュータの各構成要素をインスタンス化
		CentralProcessingUnit cpu = new CentralProcessingUnit("Core i5", 50000);
		Memory memory = new Memory("DDR4", 20000);
		HardDiskDrive hdd = new HardDiskDrive("500GBハードディスク", 3000);
		// コンピュータを構成要素を元にインスタンス化
		Computer pc = new Computer("Basic PC", 30000, cpu, memory, hdd);
		Product product = new Product("sample product", 10000);
		pc.use();
		product.use();
	}
}