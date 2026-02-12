package meetingroom.service;

import meetingroom.dto.response.ResponseBean;

public abstract class BaseService<T> {
	
	protected ResponseBean<T> responseBean;
	
	public BaseService() {
		this.responseBean = new ResponseBean<T>();
		
	}

}
