package HeroClasses;


public class Ranger extends Hero {
    WeaponType[] validWeaponType;
    public Ranger(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(1, 7, 1);
        validWeaponType = new WeaponType[] {
                WeaponType.Bows
        };
    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 5);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }

}