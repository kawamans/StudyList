package sec3;
import java.util.Scanner;
public class WarpperTest {
	public static void main(String[] args) {
		//int型の値をボクシングしてInteger型の変数へ代入
		Integer integerNum = 3;
		//Integer型変数のintegerNumとint型の演算結果をアンボクシングして代入
		int sum = integerNum * 5;
		System.out.println(sum);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("数字を入力してください->");
		String inputNum = scan.nextLine();
		Integer[] numAry = { null };
		//変換したい数字、配列が引数
		
		if (tryParse(inputNum, numAry)) {
			System.out.println(numAry[0]);
		} else {
			System.out.println("変換できません");
		}
	}
	
	// 渡された文字列を変換し、配列へ代入する
	private static boolean tryParse(String s, Integer[] numAry) {
		try {
			numAry[0] = Integer.parseInt(s); // Integerクラスのstaticメソッドを使用
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}