package sec2ex;

public class CapsuleTest {

	public static void main(String[] args) {
		Staff stf = new Staff();
		
		stf.setName("A");
		String name = stf.getName();
		stf.setSalary(201000);
		int salary = stf.getSalary();
		salary = stf.getSalary();
		
		System.out.println(name+ "さん："+ salary+ "円");
		
		stf.setName("B");
		name = stf.getName();
		stf.setSalary(202000);
		salary = stf.getSalary();
		
		System.out.println(name+ "さん："+ salary+ "円");
	}
}
