
public class Practice07 {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i*j);
				if (j < 9) {
					System.out.print(" ");
				}
			}
			if (i < 9) {
				System.out.println("\n");				
			}
		}
	}

}
