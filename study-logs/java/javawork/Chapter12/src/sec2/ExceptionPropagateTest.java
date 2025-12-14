package sec2;

public class ExceptionPropagateTest {

	public static void main(String[] args) {
		methodA();
		System.out.println("mainの処理完了");
	}
	
	private static void methodA() {
		methodB();
		System.out.println("methodAの処理完了");
	}
	
	private static void methodB() {
		methodC();
		System.out.println("methodBの処理完了");
	}
	
	private static void methodC() {
		System.out.println(24 / 0);
		System.out.println("methodCの処理完了");
	}

}
