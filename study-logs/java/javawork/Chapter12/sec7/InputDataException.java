package sec7;

public class InputDataException extends Exception {
	@Override
	public String toString() {
		return "Zero以下が入力されました。";
	}
}