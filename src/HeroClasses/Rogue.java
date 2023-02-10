package HeroClasses;


public class Rogue extends Hero {

    WeaponType[] validWeaponType;
    public Rogue (String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(2, 6, 1);
        validWeaponType = new WeaponType[] {
                WeaponType.Daggers, WeaponType.Swords
    };
    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 4);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }


}