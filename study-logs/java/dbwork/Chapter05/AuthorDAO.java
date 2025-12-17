import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
	
	private AuthorDAO() {}
	
	public static AuthorDTO getAuthorByld(String inputAuthorld) {
		AuthorDTO authorData = null;
		String sql = "SELECT * FROM author WHERE author_id = ?";
		
		try (Connection conn = DatebaseConnectonProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
				pstmt.setString(1, inputAuthorld);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					authorData = new AuthorDTO(
							rs.getString("author_id"),
							rs.getString("name"),
							rs.getString("name_kana")
					);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("SQLに関するエラーです。");
			}
		
		return authorData;
	}
	
	public static AuthorDTOList getAllAuthors() {
		AuthorDTOList authors = new AuthorDTOList();
		String sql = "SELECT * FROM author";
		
		try (Connection conn = DatebaseConnectonProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					AuthorDTO author = new AuthorDTO(
							rs.getString("author_id"),
							rs.getString("name"),
							rs.getString("name_kana")
					);
					authors.add(author);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("SQLに関するエラーです。");
			}
		
		return authors;
		
	}
	
}
