package meetingroom.dao;

public interface MemberDao {
	
	public enum MemberExecute{
		FIND_ALL,
		FIND_BY_ID,
		FIND_BY_ID_LIKE;
	}
	
	public enum MemberUpdate{
		INSERT,
		UPDATE,
		LOGICAL_DELETE;
	}
	
}
