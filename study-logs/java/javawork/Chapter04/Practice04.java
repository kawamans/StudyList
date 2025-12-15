import java.util.Scanner;

public class Practice04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("数字入力->");
		int num = scan.nextInt();
		int intCount = 0;
		int fizzCount = 0;
		int bizzCount = 0;
		int fizzBizzCount = 0;
		
		for (int i = 1; i <= num; i++) {
			
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print("FizzBuzz ");
				fizzBizzCount++;
				
			} else if (i % 5 == 0) {
				System.out.print("Buzz ");
				bizzCount++;
				
			} else if (i % 3 == 0) {
				System.out.print("Fizz ");
				fizzCount++;
				
			} else {
				System.out.print(i+ " ");
				intCount++;
			}
			if (i % 5 == 0) {
				System.out.println("\n");
			}
		}
		
		System.out.println("---計算結果---");
		System.out.println("intCount × "+ intCount+ "個");
		System.out.println("fizzCount × "+ fizzCount+ "個");
		System.out.println("bizzCount × "+ bizzCount+ "個");
		System.out.println("fizzBizzCount × "+ fizzBizzCount+ "個");
	}

}
