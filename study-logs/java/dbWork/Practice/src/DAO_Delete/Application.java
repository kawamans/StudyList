package DAO_Delete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {

	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("削除するauthor_idを入力してください：");
		
		try {
			String authorId = br.readLine();
			boolean found = AuthorDAO.deleteAuthor(authorId);
			
			if (found == true) {
				System.out.println("削除しました");
			} else {
				System.out.println("削除できませんでした");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
	}

}
