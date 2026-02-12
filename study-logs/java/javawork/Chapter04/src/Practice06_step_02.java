
public class Practice06_step_02 {

	public static void main(String[] args) {
		int num = 0;
		int goSum = 0;
		int kiSum = 0;
		
		while (num < 100) {
			num++;
			if (num % 2 == 1) {
				kiSum += num;
			} else {
				goSum += num;
			}
		} 
		System.out.println("---0～100の偶数総和---");
		System.out.println(goSum);
		System.out.println("---0～100の奇数総和---");
		System.out.println(kiSum);
	}

}
