package meetingroom.entity;

public final class MemberBean {
	
	private String id;
	private String password;
	private String name;
	private String address;
	private String adminflg;
	private String deleteflg;
	
	public MemberBean() {}
	
	public MemberBean(String id, String password, String name,String address, String adminflg) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.adminflg = adminflg;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAdminflg(String adminflg) {
		this.adminflg = adminflg;
	}
	
	public String getAdminflg() {
		return adminflg;
	}
	
	public void setDeleteflg(String deleteflg) {
		this.deleteflg = deleteflg;
	}
	
	public String getDeleteflg() {
		return deleteflg;
	}
	
	@Override
	public String toString() {
		return "MemberBean"
				+ "id = " + id + " / password = " + password + " / "
				+ "\nname = " + name + "\naddress = " + address + ""
				+ " / adminflg = " + adminflg;
	}
}
