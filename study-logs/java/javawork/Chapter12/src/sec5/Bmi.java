package sec5;

public class Bmi {
	private double sincho;
	private double taijyu;
	
	public Bmi(double sincho, double taijyu) {
		this.sincho = sincho;
		this.taijyu = taijyu;
	}
	
	public double calcBmi() {
		try {
			if (sincho <= 0 || taijyu <= 0) {
				throw new Exception();
			}
			return taijyu / ((sincho / 100) * (sincho / 100));
			
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
			return -1;
		} finally {
			System.out.println("処理が完了しました");
		}
	}
}
