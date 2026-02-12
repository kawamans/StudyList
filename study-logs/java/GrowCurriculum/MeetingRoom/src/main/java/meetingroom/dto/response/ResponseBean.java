package meetingroom.dto.response;

import java.io.Serializable;

public final class ResponseBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private int requestStatus;
	
	private T data;
	
	
	public ResponseBean() {}
	
	public ResponseBean(String message, int requestStatus, T data) {
		this.message = message;
		this.requestStatus = requestStatus;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getRequestStatus() {
		return requestStatus;
	}
	
	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}
	
}