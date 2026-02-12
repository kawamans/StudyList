
public class MultiLoopTest {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		for (int i = 1; i <= 2; i++) {
			System.out.println("---"+ i+ "の繰り返し---");
			for (int j = 1; j <= 3; j++) {
				System.out.println(j+ "回の繰り返し");
			}
			System.out.println("--------------------");
		}
		System.out.println("---処理終了---");
	}

}
