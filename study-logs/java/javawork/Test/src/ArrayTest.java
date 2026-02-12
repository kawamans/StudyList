
public class ArrayTest {
	public static void main(String[] args) {		// TODO 自動生成されたメソッド・スタブ
		int[] ary = new int[3];
		System.out.println("作成した配列の要素は"+ary.length);
		System.out.println("-------------------------------");
		
		ary[2] = 100;
		System.out.println(ary[0]+ " "+ ary[1]+ " "+ ary[2]);
		System.out.println(ary[0]+ ary[1]+ ary[2]);
		System.out.println("-------------------------------");
		
		String[] strAry = {"りんご", "みかん", "もも"};
		System.out.println(strAry[0]+ " "+ strAry[1]+ " "+ strAry[2]);
		System.out.println("-------------------------------");
		
		strAry = new String[] {"キャベツ", "人参", "トマト"};
		System.out.println(strAry[0]+ " "+ strAry[1]+ " "+ strAry[2]);
		System.out.println("-------------------------------");
	}
}