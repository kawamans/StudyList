
public class DividTest {
	public static void main(String[] args) {
		// １行コメント
		System.out.println("Hello,java World!!");//これもコメント
		/*
		 * 範囲コメント
		 */
		System.//システムクラス
		out/*プログラム改行中にもコメント*/
		.print("こんにちは！javaの世界");//文字の出力
		/*範囲でコメントアウトしている為、実行結果には反映されない
		 System.
		 out
		 .println
		 */
		System.out.println("Hello");
		System.out.println("World");
		long valInt = 10000l;
		int num = 100;
		long nums = num + valInt;
		String hoge;
		hoge = "＋";
		System.out.println(valInt+hoge);
		System.out.println(num);
		System.out.println(nums);
		
		int[] num1 = {10,20,30};
		int[] num2 = num1;
//		num2[0] = 20;
		System.out.println(num2[2]);
		
//		プリミティブ型は同じ大きさのか小→大のみ
		byte b = 1;
		short s = b;
		int n = s;
		long l = n;
		double d = l;
		System.out.println(d);
		
		long lo = 100;
		int u = (int)lo;
		System.out.println(u);
		
		
	}

}
