
public class VariableTest {

	public static void main(String[] args) {
		int num;
		num = 100;
		String str = "";
		str = "プログラミング";
		
		System.out.println("num:"+num);
		System.out.println("str:"+str);
		str = null;
		System.out.println("str:"+str);
		System.out.println("--------");
		
		double num2 = (double)num;
		System.out.println("num2:"+num2);
		num2 = 1.23;
		System.out.println("num2:"+num2);
		System.out.println("num2:"+(int)num2);
		System.out.println("--------");	
		
		char[] a = {'a','b','c'};
		System.out.println(a);
		
		String[] stmr = {"frg1","frg2","frg3"};
		System.out.println(stmr[0]);
		System.out.println("--------");	
		
		int[] ary = new int[3];
		ary[0] = 1;
		ary[1] = 2;
		ary[2] = 3;
		System.out.println("配列数は"+ary.length);
		System.out.println("ary[2]= "+ary[2]);
		
		
	}

}
