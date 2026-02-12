package monster;

public class BlueEyes extends Evolution {
	
	public BlueEyes(String name, String skill) {
		super(name, skill);
	}
	
	@Override
	public void evolution() {
		System.out.println(super.getBeforeName() + "は" + super.getAfterName() + "に進化した！");
	}
	
	@Override
	public void skillUp() {
		System.out.println(super.getBeforeSkill() + "は" + super.getAfterSkill() + "に進化した！");
	}
	
}
