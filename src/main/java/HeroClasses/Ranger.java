package HeroClasses;


public class Ranger extends Hero {
    public Ranger(String name) throws Exception {
        super(name);
        heroClass = "Ranger";
        this.levelAttributes = new HeroAttribute(1, 7, 1);
        validWeaponTypes.add(WeaponType.Bows);
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
        this.levelAttributes.setDexterity(this.levelAttributes.getDexterity() + 5);
        this.levelAttributes.setIntelligence(this.levelAttributes.getIntelligence() + 1);
        this.level += 1;

    }

}