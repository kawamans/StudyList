package monster;

public abstract class Monster {
	
	private String name;
	private String skill;
	
	public Monster(String name, String skill) {
		this.name = name;
		this.skill = skill;
	}
	
	public abstract void sayName();
	
	public abstract void attack();
	
	protected String getName() {
		return name;
	}
	
	public String getSkill() {
		return skill;
	}
	
}
