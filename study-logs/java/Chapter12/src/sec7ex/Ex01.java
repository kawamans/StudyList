package sec7ex;

public class Ex01 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;
		int ans = 0;
		System.out.println("処理開始");
		try {
			System.out.println("計算開始");
			ans = calc(num1, num2);
			System.out.println("計算終了");
//		} catch (ArithmeticException e) {
//			System.out.println("計算エラー");
		
		} catch (Exception e) {
			System.out.println("その他の例外");
		
		} finally {
			System.out.println("完了しました");
			
		}
		System.out.println(num1 + "/" + num2 + "=" + ans);
		System.out.println("処理終了");
	}

	public static int calc(int num1, int num2) {
		return num1 / num2;
	}
}
