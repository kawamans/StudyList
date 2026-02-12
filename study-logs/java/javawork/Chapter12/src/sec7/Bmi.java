package sec7;

public class Bmi {
	// フィールド
	private double sincho;
	private double taijyu;
	// コンストラクタ
	public Bmi(double sincho, double taijyu) {
		try {
			if (sincho <= 0 || taijyu <= 0) {
				throw new InputDataException();
			}
			this.sincho = sincho;
			this.taijyu = taijyu;
		} catch (Exception ex) {
			System.out.println("身長、体重のどちらかに0以下の値が指定されています");
		}
	}
	// メソッド
	public double calcBMI() throws InputDataException {
		if (sincho <= 0 || taijyu <= 0) {
			throw new InputDataException();
		}
		return taijyu / ((sincho / 100) * (sincho / 100));
	}
}