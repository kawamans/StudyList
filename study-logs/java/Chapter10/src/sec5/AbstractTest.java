package sec5;

public class AbstractTest {
	public static void main(String[] args) {
		CentralProcessingUnit cpu = new CentralProcessingUnit("Core i5", 50000);
	Memory memory = new Memory("DDR4", 20000);
		HardDiskDrive hdd = new HardDiskDrive("500GBハードディスク", 3000);
		Computer pc = new Computer("Basic PC", 30000, cpu, memory, hdd);
		System.out.print(pc);
		pc.use();
	}
}