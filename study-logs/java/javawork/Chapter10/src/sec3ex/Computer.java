package sec3ex;

public class Computer extends Product{
	private CentralProcessingUnit cpu;
	private Memory memory;
	private HardDiscDrive hdd;
	//Ex03
	public Computer(String name) {
		super(name);
	}
	
	public Computer(String name, int price, CentralProcessingUnit cpu, Memory memory, HardDiscDrive hdd) {
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
	public HardDiscDrive getHdd() {
		return hdd;
	}
	public void setHdd(HardDiscDrive hdd) {
		this.hdd = hdd;
	}
//	public void use() {
//		System.out.println("パソコンを使用しています");
//	}
}
