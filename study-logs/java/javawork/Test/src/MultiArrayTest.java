
public class MultiArrayTest {

	public static void main(String[] args) {
		int[][] ary = new int[2][3];
		ary[0][0] = 1;
		ary[0][2] = 3;
		ary[1][0] = 4;
		ary[1][1] = 5;
		
		System.out.println(ary[0][0]+ " "+ ary[0][1]+ " "+ ary[0][2]);
		System.out.println(ary[1][0]+ " "+ ary[1][1]+ " "+ ary[1][2]);
		
		int[][] ary2 = {
				{10, 20, 30},
				{40, 50, 60}
		};
		System.out.println("-----------------------------------");
		System.out.println(ary2[0][0]+ " "+ ary2[0][1]+ " "+ ary2[0][2]);
		System.out.println(ary2[1][0]+ " "+ ary2[1][1]+ " "+ ary2[1][2]);
	}
	
}
