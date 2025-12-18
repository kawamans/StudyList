public class Application {

	public static void main(String[] args) {

		AuthorDTOList authorDatas = AuthorDAO.getAllAuthors();
		
		for (AuthorDTO authorData : authorDatas) {
			System.out.print(authorData.getAuthorld() + "\t");
			System.out.print(authorData.getName() + "\t");
			System.out.println(authorData.getName_kana());
		}
		
	}

}
