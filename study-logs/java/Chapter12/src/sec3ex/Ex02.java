package sec3ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		
		for(int i = 0; i < 5; i++) {
			try {
					System.out.println(a[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("X");
			} 
		}
	}
}
