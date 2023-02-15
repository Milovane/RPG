package HeroClasses;


public class Rogue extends Hero {
    public Rogue (String name) throws Exception {
        super(name);
        heroClass = "Rogue";
        this.levelAttributes = new HeroAttribute(2, 6, 1);
        validWeaponTypes.add(WeaponType.Daggers);
        validWeaponTypes.add(WeaponType.Swords);
        validArmorTypes.add(ArmorType.Leather);
        validArmorTypes.add(ArmorType.Mail);
    }

    @Override
    public double totalDamage() {
        double damagingAttribute = totalAttributes().Dexterity;
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
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 4);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }


}