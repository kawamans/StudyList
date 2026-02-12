package sec4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("C:\\javawork\\test.txt");
			br = new BufferedReader(fr);
			String str = null;
			
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
			System.out.println("ファイルから読み込みました。");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (br != null) {
				br.close();				
			}
			if (fr != null) {
				fr.close();				
			}
			
		}
		
	}

}
