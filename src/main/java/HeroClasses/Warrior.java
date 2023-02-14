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
    public int totalDamage() {
        int damagingAttribute = totalAttributes().Strength;
        var weapon = (Weapon)equipment.get(Slot.Weapon);
        int weaponDamage = 1;
        if (weapon != null)
            weaponDamage = weapon.weaponDamage;

        return weaponDamage * (1 + damagingAttribute / 100);
    }

    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 3);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 2);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }

}