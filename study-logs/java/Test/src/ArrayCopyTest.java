public class ArrayCopyTest {
	public static void main(String[] args) {
		// 配列変数の宣言・初期化
		int[] intAry1 = { 10, 20 };
		// 配列コピー?
		int[] intAry2 = intAry1;
		System.out.println("---配列コピー?後---");
		System.out.println("intAry1:" + intAry1[0] + " " + intAry1[1]);
		System.out.println("intAry2:" + intAry2[0] + " " + intAry2[1]);
		// intAry2[1]への代入？
		intAry2[1] = 200;
		System.out.println("---配列コピー?代入後---");
		System.out.println("intAry1:" + intAry1[0] + " " + intAry1[1]);
		System.out.println("intAry2:" + intAry2[0] + " " + intAry2[1]);
		// 配列変数の宣言・初期化
		int[] intAry3 = { 10, 20 };
		int[] intAry4 = new int[2];
		// 配列の要素をコピー
		intAry4[0] = intAry3[0];
		intAry4[1] = intAry3[1];
		System.out.println("---配列の要素をコピー後---");
		System.out.println("intAry3:" + intAry3[0] + " " + intAry3[1]);
		System.out.println("intAry4:" + intAry4[0] + " " + intAry4[1]);
		intAry4[1] = 200;
		System.out.println("---配列の要素をコピー代入後---");
		System.out.println("intAry3:" + intAry3[0] + " " + intAry3[1]);
		System.out.println("intAry4:" + intAry4[0] + " " + intAry4[1]);
	}
}