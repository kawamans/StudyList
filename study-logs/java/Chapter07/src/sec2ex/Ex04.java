package sec2ex;

public class Ex04 {

	public static void main(String[] args) {
		Car car = new Car("シリウス", 38.0, 45.0);
		car.charge(10);
		car.drive(200);
		car.charge(10);
		car.drive(600);
		System.out.println("現在のデータ："+ car.getName()+ "："+ car.getOdo()+"km");
	}

}
