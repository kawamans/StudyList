package meetingroom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

import meetingroom.constant.ConstMemberSQL;
import meetingroom.dto.request.RequestMemberBean;
import meetingroom.entity.MemberBean;
import meetingroom.util.DBUtil;

public class MenberDaoImpl implements MemberDao {
	
	private StringBuilder sbQuery;
	private RequestMemberBean reqMember = null;
	
	public List<MemberBean> memberExecuteDBAccess(final MemberExecute mCase, final List<RequestMemberBean> reqMemberBeanList) {
		
		try(Connection conn = DBUtil.getDBConnection();
				PreparedStatement pstmt = conn.prepareStatement(this.sbQuery.toString());){
			
			memberExecuteResultSet(mCase, pstmt);
			
			try(ResultSet rs = pstmt.executeQuery();){
				
				while (rs.next()) {
					MemberBean memberBean = new MemberBean(
							rs.getString("id"), 
							rs.getString("password"),
							rs.getString("name"),
							rs.getString("address"),
							rs.getString("adminflg"));
					
					reqMemberBeanList.add(memberBean);
					memberBean = null;
				}
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return memberBeanList;
	}
	
	private void MemberExecuteQuery(final MemberExecute meCase, final List<RequestMemberBean> reqMemberBeanList) {
		
		this.sbQuery = new StringBuilder(ConstMemberSQL.SELECT_BASE.length());
		sbQuery.append(ConstMemberSQL.SELECT_BASE);
		
		try{
			
			switch (meCase) {
				case FIND_ALL: 
					sbQuery.append(ConstMemberSQL.SELECT_BY_DELETE_FLG_ZERO);
					break;
					
				case FIND_BY_ID:
					
					reqMember = reqMemberBeanList.stream().findFirst().orElse(null);
					
					if(Objects.nonNull(reqMember.getId())) {
						this.sbQuery.append(ConstMemberSQL.SELECT_BY_ID);
					}
					break;
				default:
					
					break;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	private void memberExecuteResultSet(final MemberExecute meCase, PreparedStatement pstmt) {
		
		try {
			
			if(Objects.nonNull(this.reqMember)) {
				final String memberId = MemberExecute.FIND_BY_ID.equals(meCase)
						? reqMember.getId() : ("%" + reqMember.getId() + "%");
				
				pstmt.setString(1, memberId);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
