import java.util.Scanner;

public class ContinueBreakTest {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		int num = 0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("数字を入力してください->");
		int endNum = scan.nextInt();
		while (true) {
			num++;
			if (num > endNum) {
				break;
			}
			if (num % 3 == 0) {
				count++;
				System.out.println("\t"+ num);
				continue;
			}
			System.out.println(num);
		}
		System.out.println("1∼"+ endNum+ "の間で3の倍数は"+ count+ "個ありました");
		System.out.println("---処理終了---");
	}

}
