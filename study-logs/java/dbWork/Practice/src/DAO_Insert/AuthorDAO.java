package DAO_Insert;
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
	
	public static boolean deleteAuthor(String authorId) {
		String sql = "DELETE FROM author WHERE author_id = ?";
		boolean found = false;
		
		try (Connection conn = DatebaseConnectonProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			try {
				pstmt.setString(1, authorId);
				int num = pstmt.executeUpdate();
				
				return num > 0;
				
			} catch (SQLException e) {
				return found;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
			return found;
		}
		
	}
	
	public static boolean insertAuthor(AuthorDTO author) {
		String sql = "INSERT INTO author "
				+ "(author_id, name, name_kana) VALUES "
				+ "(?, ?, ?)";
		boolean found = false;
		
		try (Connection conn = DatebaseConnectonProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			try {
				pstmt.setString(1, author.getAuthorld());
				pstmt.setString(2, author.getName());
				pstmt.setString(3, author.getName_kana());
				int num = pstmt.executeUpdate();
				
				return num > 0;
				
			} catch (SQLException e) {
				return found;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
			return found;
		}
		
	}
}
