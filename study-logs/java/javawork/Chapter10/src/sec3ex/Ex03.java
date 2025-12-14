package sec3ex;

public class Ex03 {

	public static void main(String[] args) {
		Computer pc = new Computer("名前だけが決まったパソコン");
		
		System.out.println("パソコン名:" + pc.getName());
		System.out.println("CPU:" + pc.getCpu());
		System.out.println("メモリ:" + pc.getMemory());
		System.out.println("HDD:" + pc.getHdd());
		System.out.println("販売価格:" + pc.getPrice());
		
	}

}
