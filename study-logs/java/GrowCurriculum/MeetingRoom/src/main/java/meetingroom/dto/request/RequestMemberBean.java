package meetingroom.dto.request;

public class RequestMemberBean {
	
	private String id;
	private String password;
	private String name;
	private String birthYear;
	private String address;
	private String adminflg;
	
	public RequestMemberBean() {}
	
	public RequestMemberBean(String id, String password, String name, String address, String adminflg) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.adminflg = adminflg;
	}
	
	public RequestMemberBean(String insert, String password, String name, String birthYear, String address, String adminflg) {
		this.password = password;
		this.name = name;
		this.birthYear = birthYear;
		this.address = address;
		this.adminflg = adminflg;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAdminflg() {
		return adminflg;
	}
	
	public void setAdminflg(String adminflg) {
		this.adminflg = adminflg;
	}
	
	@Override
	public String toString() {
		return "MemberBean"
				+ "id = " + id + " / password = " + password + " / "
				+ "\nname = " + name + " / birthYear = " + birthYear + " / "
				+ "\naddress = " + address + " / adminflg = " + adminflg;
	}
}
