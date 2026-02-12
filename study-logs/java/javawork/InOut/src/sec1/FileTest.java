package sec1;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		try {
			File dir = new File("C:\\javawork");
			if (dir.exists()) {
				System.out.println("フォルダが、見つかりました");
			} else {
				System.out.println("フォルダが、見つかりません");
				dir.mkdir();
				System.out.println("フォルダを作成しました");
			}
			
			File file = new File("C:\\javawork\\test.txt");
			if (file.exists()) {
				System.out.println("ファイルが、見つかりました");
			} else {
				System.out.println("ファイルが、見つかりません");
				file.createNewFile();
				System.out.println("ファイルを作成しました");
			}
			
		} catch (Exception e) {
				System.out.println("例外が発生しました。");
		}
	}
}