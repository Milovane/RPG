package HeroClasses;


public class Mage extends Hero {
    WeaponType[] validWeaponType;
    ArmorType[] validArmorType;
    public Mage(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(1, 1, 8);
        validWeaponType = new WeaponType[] {
                WeaponType.Staffs, WeaponType.Wands
        };
        validArmorType = new ArmorType[] {
                ArmorType.Cloth
        };

    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 1);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 5);
        this.level += 1;

    }


}
