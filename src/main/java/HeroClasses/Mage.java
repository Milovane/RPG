package HeroClasses;


public class Mage extends Hero {
    public Mage(String name) throws Exception {
        super(name);
        heroClass = "Mage";
        this.levelAttributes = new HeroAttribute(1, 1, 8);
        validWeaponTypes.add(WeaponType.Staffs);
        validWeaponTypes.add(WeaponType.Wands);
        validArmorTypes.add(ArmorType.Cloth);

    }
@Override
    public int totalDamage() {
        int damagingAttribute = totalAttributes().Intelligence;
        var weapon = (Weapon)equipment.get(Slot.Weapon);
        int weaponDamage = 1;
        if (weapon != null)
            weaponDamage = weapon.weaponDamage;

        return weaponDamage * (1 + damagingAttribute / 100);
    }

    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 1);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 5);
        this.level += 1;

    }


}
