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
    public double totalDamage() {
        double damagingAttribute = totalAttributes().Intelligence;
        var weapon = (Weapon)equipment.get(Slot.Weapon);
        double weaponDamage = 1;
        if (weapon != null)
            weaponDamage = weapon.weaponDamage;

    double damage = weaponDamage * (1 + damagingAttribute / 100);
    //Math.round is used to remove decimals since the result would otherwise be "0.000000000003"
    double result = Math.round(damage * 100.0) / 100.0;


    return result;
    }

    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 1);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 5);
        this.level += 1;

    }


}
