package sec2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KerBoardTest {

	public static void main(String[] args) throws IOException {
		String str = "";
		while (!str.equals("0")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("何か入力してください：");
			str = br.readLine();
			System.out.println("入力した文字列：" + str);
		}
	}

}
