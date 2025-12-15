package sec3;

public class Computer extends Product {
	// フィールド
	private CentralProcessingUnit cpu;
	private Memory memory;
	private HardDiskDrive hdd;
	// コンストラクタ
	public Computer(String name, int price, CentralProcessingUnit cpu, Memory memory, HardDiskDrive hdd) {
		super(name, price);
		this.cpu = cpu;
		this.memory = memory;
		this.hdd = hdd;
	}
	public CentralProcessingUnit getCpu() {
		return cpu;
	}
	public void setCpu(CentralProcessingUnit cpu) {
		this.cpu = cpu;
	}
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	public HardDiskDrive getHdd() {
		return hdd;
	}
	public void setHdd(HardDiskDrive hdd) {
		this.hdd = hdd;
	}
	@Override
	public void use() {
		System.out.println("パソコンを使用します");
	}
}