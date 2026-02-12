package meetingroom.exception;

import java.util.List;

import meetingroom.dto.response.ResponseBean;
import meetingroom.entity.MemberBean;

public class MemberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private ResponseBean<List<MemberBean>> responseMember;
	
	
	public MemberException(final ResponseBean<List<MemberBean>> responseMember) {
		super();
		this.responseMember = responseMember;
	}
	
	public MemberException(final ResponseBean<List<MemberBean>> responseMember, Throwable throwable) {
		super(throwable);
		this.responseMember = responseMember;
	}
	
	public ResponseBean<List<MemberBean>> getResponseMember() {
		return responseMember;
	}
	
	public void setResponseMember(ResponseBean<List<MemberBean>> responseMember) {
		this.responseMember = responseMember;
	}
	
}
