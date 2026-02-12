package sec1ex;

public class Ex01 {

	public static void main(String[] args) {
		CentralProcessingUnit cpu = new CentralProcessingUnit("Core i7", 70000);
		Memory memory = new Memory("DDR4", 20000);
		HardDiskDrive hdd = new HardDiskDrive("1TBハードディスク", 8000);
		Computer pc = new Computer("Basic PC", 30000, cpu, memory, hdd);
		
		String pcName = pc.getName();
		String cpuName = pc.getCpu().getName();
		String memoryName = pc.getMemory().getName();
		String hddName = pc.getHdd().getName();
		
		pc.getMemory().setPrice(8000);
		
		int pcPrice = pc.getPrice()+
				pc.getCpu().getPrice()+
				pc.getMemory().getPrice()+
				pc.getHdd().getPrice();
		
		System.out.println("パソコン名："+ pcName);
		System.out.println("CPU："+ cpuName);
		System.out.println("メモリ："+ memoryName);
		System.out.println("HDD："+ hddName);
		System.out.println("販売価格："+ pcPrice);
		
	}

}
