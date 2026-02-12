package sec2ex;

public class Car {
	String name;
	double gas;
	double odo;
	double efficiency;
	double tank;
	
	public Car(String name, double efficiency, double tank) {
		this.name = name;
		this.efficiency = efficiency;
		this.tank = tank;
	}
	
	public String getName() {
		return name;
	}
	
	public double getOdo() {
		return odo;
	}
	
	public void drive(double distance) {
		double sumDistance;
		double maxDistance = this.gas * this.efficiency;
		if (distance <= maxDistance) {
			sumDistance = distance;
		} else {
			sumDistance = maxDistance;
		}
		this.odo += sumDistance;
		this.gas -= sumDistance / this.efficiency;
	}
	
	public void charge(double gas) {
		this.gas += gas;
		if (this.gas >= this.tank) {
			this.gas = this.tank;
		}
	}
}
