package monster;

public class Slime extends Monster {
	
	public Slime(String name, String skill) {
		super(name, skill);
	}
	
	@Override
	public void sayName() {
		System.out.println(super.getName() + "があらわれた！");
	}
	
	@Override
	public void attack() {
		System.out.println(super.getSkill() + "で攻撃！");
	}
	
}
