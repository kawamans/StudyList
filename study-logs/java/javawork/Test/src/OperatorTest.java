public class OperatorTest {
	public static void main(String[] args) {
		// 変数の宣言
		int num1 = 10;
		int num2 = 3;
		// 四則演算
		System.out.println("加算:" + (num1 + num2));
		System.out.println("減算:" + (num1 - num2));
		System.out.println("乗算:" + (num1 * num2));
		System.out.println("整数除算:" + (num1 / num2));
		System.out.println("小数点数除算:" + ((double) num1 / num2));
		System.out.println("剰余算:" + (num1 % num2));
		// 比較演算
		System.out.println("比較演算==:" + (num1 == num2));
		System.out.println("比較演算!=:" + (num1 != num2));
		System.out.println("---------------------------------");
		// インクリメント、デクリメント
		num1++;
		System.out.println("インクリメント:" + num1);
		num1--;
		System.out.println("デクリメント:" + num1);
		System.out.println("---------------------------------");
		double num3 = 1.0;
		double num4 = 0.9;
		System.out.println(num3-num4);
		System.out.println((num3*10-num4*10)/10);
		
		
	}
}