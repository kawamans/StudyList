package sec3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) throws IOException{
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("C:\\javawork\\test.txt", true);
			bw = new BufferedWriter(fw);
			bw.write("java文法");
			bw.newLine();
			bw.write("Javaオブジェクト指向");
			bw.newLine();
			bw.flush();
			System.out.println("ファイルに書き込みました");
					
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (bw != null) {
				bw.close();
			}
			if (fw != null) {
				fw.close();
			}
		}
	}

}
