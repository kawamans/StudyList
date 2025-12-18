import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		int num = 0;
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		switch (num) {
		case 0:
			System.out.println("saceラベル"+ num+ "と一致した場合の処理が行われました");
			break;
		case 1:
			System.out.println("saceラベル"+ num+ "と一致した場合の処理が行われました");
			break;
		default:
			System.out.println("全てのsaceラベルと一致しなかった為、defaultの処理が行われました");
			break;
		}
		System.out.println("---処理終了---");
	}

}
