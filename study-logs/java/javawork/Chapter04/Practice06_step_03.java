import java.util.Scanner;

public class Practice06_step_03{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("開始の数-> ");
		int startNum = scan.nextInt();
		System.out.print("終了の数-> ");
		int endNum = scan.nextInt();
		
		int sum = 0;
		int goSum = 0;
		int kiSum = 0;
		
		int num = startNum;
		
		while (num <= endNum) {
			sum += num;
			if (num % 2 == 1) {
				kiSum += num;
			} else {
				goSum += num;
			}
			num++;
		} 
		
		System.out.println("---"+ startNum+ "～"+ endNum+ "の総和---");
		System.out.println(sum);
		System.out.println("---"+ startNum+ "～"+ endNum+ "の偶数総和---");
		System.out.println(goSum);
		System.out.println("---"+ startNum+ "～"+ endNum+ "の奇数総和---");
		System.out.println(kiSum);
	}

}