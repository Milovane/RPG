package HeroClasses;


public class Warrior extends Hero {
    public Warrior (String name) throws Exception {
        super(name);
        heroClass = "Warrior";
        this.levelAttributes = new HeroAttribute(5, 2, 1);
        validWeaponTypes.add(WeaponType.Axes);
        validWeaponTypes.add(WeaponType.Swords);
        validWeaponTypes.add(WeaponType.Hammers);
        validArmorTypes.add(ArmorType.Plate);
        validArmorTypes.add(ArmorType.Mail);

    }
    @Override
    public double totalDamage() {
        double damagingAttribute = totalAttributes().Strength;
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
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 3);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 2);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }

}