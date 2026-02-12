package monster;

public class Dragon extends Monster {
	
	public Dragon(String name, String skill) {
		super(name, skill);
	}
	
	@Override
	public void sayName() {
		System.out.println("ボスの" + super.getName() + "があらわれた！");
	}
	
	@Override
	public void attack() {
		System.out.println(super.getSkill() + "で全体を攻撃！");
	}
	
}
