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
    public int totalDamage() {
        int damagingAttribute = totalAttributes().Dexterity;
        var weapon = (Weapon)equipment.get(Slot.Weapon);
        int weaponDamage = 1;
        if (weapon != null)
            weaponDamage = weapon.weaponDamage;

        return weaponDamage * (1 + damagingAttribute / 100);
    }

    @Override
    public void levelUp() {
        this.levelAttributes.setStrength(this.levelAttributes.getStrength() + 1);
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 4);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }


}