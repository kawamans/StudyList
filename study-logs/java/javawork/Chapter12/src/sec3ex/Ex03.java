package sec3ex;

public class Ex03 {
	public static void main(String[] args) {
		methodA();
		System.out.println("mainの処理完了");
	}
	
	private static void methodA() {
		methodB();
		System.out.println("methodAの処理完了");
	}
	
	private static void methodB() {
		try {
			methodC();
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.out.println("methodBで例外をキャッチしました");
		}
		System.out.println("methodBの処理完了");
	}
	
	private static void methodC() {
		System.out.println(24 / 0);
		System.out.println("methodCの処理完了");
	}
	
}
