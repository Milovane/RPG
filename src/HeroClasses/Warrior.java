package HeroClasses;


public class Warrior extends Hero {

    WeaponType[] validWeaponType;
    ArmorType[] validArmorType;
    public Warrior (String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(5, 2, 1);
        validWeaponType = new WeaponType[] {
                WeaponType.Axes, WeaponType.Swords, WeaponType.Hammers
        };
        validArmorType = new ArmorType[] {
                ArmorType.Plate, ArmorType.Mail
        };

    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 3);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 2);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }

}