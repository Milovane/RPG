package HeroClasses;


public class Weapon extends Item {
    WeaponType weaponType;
    int weaponDamage;
    public Weapon(String name, int requiredLevel,Slot slot, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, slot);
        this.weaponType = weaponType;
    }

    @Override
    public boolean ValidEquip(Hero hero) {
        if (hero.validWeaponTypes.contains(weaponType) && hero.level >= requiredLevel)
            return true;

            return false;
    }
}
