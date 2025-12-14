package sec5;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TryWithResourcerTest {

	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("C:\\javawork\\test.txt");
		BufferedWriter bw = new BufferedWriter(fw)) {
			
			bw.write("Java文法");
			bw.newLine();
			bw.write("オブジェクト指向");
			bw.flush();
			System.out.println("ファイルに書き込みました");
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}

}
