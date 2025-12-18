import java.util.Scanner;

public class Practice10_step_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] enzanText = {"加算", "減算", "乗算", "除算"};
		System.out.println("---演算の種別を選択してください(0で終了)---");
		System.out.print("1：加算 2：減算 3：乗算 4：除算 -> ");
		int enzanInt = scan.nextInt();
		
		if (enzanInt < 0 || 4 < enzanInt) {
			while (enzanInt < 0 || 4 < enzanInt) {
				System.out.println("---演算の種別は1～4です(0で終了)---");
				System.out.print("1：加算 2：減算 3：乗算 4：除算 -> ");
				int num = scan.nextInt();
				enzanInt = num;
			}
			System.out.print("\n");
		}
		
		if (enzanInt == 0) {
			System.out.println("[0]コマンド");
		} else {
			System.out.println("---"+ enzanText[enzanInt-1]+ "を選択しています---");
			System.out.print("1つ目の数値 -> ");
			int num1 = scan.nextInt();
			System.out.print("2つ目の数値 -> ");
			int num2 = scan.nextInt();
			System.out.println("---計算結果---");
			if (enzanInt == 1) {
				kasan(num1, num2);
			} else if (enzanInt == 2) {
				gensan(num1, num2);
			} else if (enzanInt == 3) {	
				jousan(num1, num2);
			} else {
				josan(num1, num2);
			} 
		}
		System.out.println("---計算終了---");	
	}
	
	public static void kasan(int num1, int num2) {
		System.out.println("加算："+ (num1 + num2));
	}
	
	public static void gensan(int num1, int num2) {
		System.out.println("減算："+ (num1 - num2));
	}
	
	public static void jousan(int num1, int num2) {
		System.out.println("乗算："+ (num1 * num2));
	}
	
	public static void josan(int num1, int num2) {
		System.out.println("除算："+ (num1 / num2));
	}

}
