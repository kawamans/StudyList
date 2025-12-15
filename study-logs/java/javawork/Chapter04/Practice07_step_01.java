
public class Practice07_step_01 {

	public static void main(String[] args) {
		int[][] multiArray = new int[9][9];
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				multiArray[i-1][j-1] = i*j;
				System.out.print(multiArray[i-1][j-1]);
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
