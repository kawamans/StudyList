import java.util.Scanner;

public class NonMethodTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("キーボードから点数を入力してください");
		System.out.print("科目Aの点数-> ");
		int subjectA = scan.nextInt();
		System.out.print("科目Bの点数-> ");
		int subjectB = scan.nextInt();
		System.out.print("科目Cの点数-> ");
		int subjectC = scan.nextInt();
		System.out.println("-------------------");
		System.out.println("3教科の総合点数を計算する");
		System.out.println("3教科合計："+ subjectA+ subjectB+ subjectC+ "点");
		System.out.println("3教科の総合点数を計算する");
		System.out.println("3教科合計："+ subjectA+ subjectB+ subjectC+ "点");
		System.out.println("3教科の総合点数を計算する");
		System.out.println("3教科合計："+ subjectA+ subjectB+ subjectC+ "点");
	}

}
