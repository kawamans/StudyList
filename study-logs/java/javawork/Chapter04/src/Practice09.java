import java.util.Scanner;

public class Practice09 {

	public static void main(String[] args) {
		System.out.println("---実行---");
		Scanner scan = new Scanner(System.in);
		System.out.print("コマンド(0 or 1) -> ");
		int command = scan.nextInt();
		selfcommand(command);
		selfText(command);
		System.out.println("---終了---");
	}
	
	public static int selfcommand(int command) {
		if (command < 0 || command > 1) {
			while (command < 0 || command > 1) {
				Scanner scan = new Scanner(System.in);
				System.out.print("コマンドは(0 or 1) ->");
				int i = scan.nextInt();
				command = i;
			}
		}
		return command;
	}

	public static String[] action(int command) {
		if (command == 0) {
			String[] text = {"わたしの名前は川満達也です", "趣味は料理です","頑張ります"};
			return text;
		} else {
			String[] text = {"mu name is Tatsuya Kawamitsu", "hobby is cooking","I will do my best"};
			return text;
		}
	}
	
	public static void selfText(int command) {
		String[] text = action(command);
		System.out.println(text[0]);
		System.out.println(text[1]);
		System.out.println(text[2]);
	}
}

