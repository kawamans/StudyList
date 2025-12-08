
package sec1;

public class Computer {
	// フィールド
	private String name;
	private int price;
	private CentralProcessingUnit cpu;
	private Memory memory;
	private HardDiskDrive hdd;
	// コンストラクタ
	public Computer(String name, int price, CentralProcessingUnit cpu, Memory memory, HardDiskDrive hdd) {
		this.name = name;
		this.price = price;
		this.cpu = cpu;
		this.memory = memory;
		this.hdd = hdd;
	}
	// メソッド
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
}