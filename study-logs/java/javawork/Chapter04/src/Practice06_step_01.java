
public class Practice06_step_01 {

	public static void main(String[] args) {
		System.out.println("---0～100の総和---");
		int num = 0;
		int sum = 0;
		
		do {
			num++;
			if (num % 2 == 1) {
			sum += num;
			}
		} while (num < 100);
		System.out.println(sum);
	}

}
