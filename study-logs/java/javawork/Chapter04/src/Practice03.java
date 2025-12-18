import java.util.Scanner;

public class Practice03 {

	public static void main(String[] args) {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("和風月名を表示できます");
		System.out.print("1～12の数字を入力してください->");
		num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("睦月");
			break;
		case 2:
			System.out.println("如月");
			break;
		case 3:
			System.out.println("弥生");
			break;
		case 4:
			System.out.println("卯月");
			break;
		case 5:
			System.out.println("皐月");
			break;
		case 6:
			System.out.println("水無月");
			break;
		case 7:
			System.out.println("文月");
			break;
		case 8:
			System.out.println("葉月");
			break;
		case 9:
			System.out.println("長月");
			break;
		case 10:
			System.out.println("神無月");
			break;
		case 11:
			System.out.println("霜月");
			break;
		case 12:
			System.out.println("師走");
			break;
		default:
			System.out.println("1～12を入力してください");
			break;
		}
		System.out.println("---処理終了---");
	}

}
