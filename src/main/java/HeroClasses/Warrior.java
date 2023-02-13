package HeroClasses;


public class Warrior extends Hero {
    public Warrior (String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(5, 2, 1);
        validWeaponTypes.add(WeaponType.Axes);
        validWeaponTypes.add(WeaponType.Swords);
        validWeaponTypes.add(WeaponType.Hammers);
        validArmorTypes.add(ArmorType.Plate);
        validArmorTypes.add(ArmorType.Mail);

    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 3);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 2);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }

}