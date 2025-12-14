import java.util.Scanner;

public class Practice10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---数値を2回入力してください---");
		System.out.print("1つ目の数値 -> ");
		int num1 = scan.nextInt();
		System.out.print("2つ目の数値 -> ");
		int num2 = scan.nextInt();
		System.out.println("---計算結果---");
		kasan(num1, num2);
		gensan(num1, num2);
		jousan(num1, num2);
		josan(num1, num2);
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
