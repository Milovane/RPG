package HeroClasses;


import java.util.List;

public class Mage extends Hero {
    public Mage(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(1, 1, 8);
        validWeaponTypes.add(WeaponType.Staffs);
        validWeaponTypes.add(WeaponType.Wands);
        validArmorTypes.add(ArmorType.Cloth);

    }
    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 1);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 5);
        this.level += 1;

    }


}
