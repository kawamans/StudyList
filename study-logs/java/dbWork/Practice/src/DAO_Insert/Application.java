package DAO_Insert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {

	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			System.out.print("author_id：");
			String authorId = br.readLine();
			System.out.print("name：");
			String name = br.readLine();
			System.out.print("name_kana：");
			String name_kana = br.readLine();
			AuthorDTO arthordto = new AuthorDTO(authorId, name, name_kana);
			
			boolean found = AuthorDAO.insertAuthor(arthordto);
			
			if (found == true) {
				System.out.println("追加しました");
			} else {
				System.out.println("追加できませんでした");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
	}

}
