package HeroClasses;


public class Rogue extends Hero {
    public Rogue (String name) throws Exception {
        super(name);
        this.levelAttributes = new HeroAttribute(2, 6, 1);
        validWeaponTypes.add(WeaponType.Daggers);
        validWeaponTypes.add(WeaponType.Swords);
        validArmorTypes.add(ArmorType.Leather);
        validArmorTypes.add(ArmorType.Mail);
    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 4);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }


}