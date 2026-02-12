package sec7;

public class FinallyTest {

	public static void main(String[] args) {
		try {
			int a = 6, b = 0;
			int c = a / b;
			System.out.println(a + "÷" + b + "=" + c);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("配列の要素外にアクセスしました");
		} catch (ArithmeticException e) {
			System.err.println("ゼロ除算が発生しました");
		} catch (Exception e) {
			System.err.println("例外が発生しました");
		} finally {
			System.out.println("処理が完了しました");
		}
	}

}
