package monster;

public abstract class Evolution {
	
	private String beforeName;
	private String afterName;
	private String beforeSkill;
	private String afterSkill;
	
	public Evolution(String name, String skill) {
		this.beforeName = name;
		this.afterName = "ブルーアイズホワイト" + name;
		this.beforeSkill = skill;
		this.afterSkill = "滅びの爆裂疾風弾";
	}
	
	public abstract void evolution();
	
	public abstract void skillUp();
	
	public String getBeforeName() {
		return beforeName;
	}
	
	public String getAfterName() {
		return afterName;
	}
	
	public String getBeforeSkill() {
		return beforeSkill;
	}
	
	public String getAfterSkill() {
		return afterSkill;
	}
	
}
