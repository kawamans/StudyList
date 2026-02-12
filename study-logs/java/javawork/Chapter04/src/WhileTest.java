
public class WhileTest {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		int num = 0;
		int sum = 0;
		
		while (num > 3) {
			num++;
			sum += num;
		}
		
		System.out.println(sum);
		System.out.println("------------");
		
		do {
			num++;
			sum += num;
		} while (num > 3);
		
		System.out.println(sum);
		System.out.println("---処理終了---");
	}

}
