package sec6;

public class Bmi {
	// フィールド
	private double sincho;
	private double taijyu;
	// コンストラクタ
	public Bmi(double sincho, double taijyu) {
		this.sincho = sincho;
		this.taijyu = taijyu;
	}
	// メソッド
	public double calcBMI() throws Exception {
		if (sincho <= 0 || taijyu <= 0) {
			throw new Exception();
		}
		return taijyu / ((sincho / 100) * (sincho / 100));
	}
}