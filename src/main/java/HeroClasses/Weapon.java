package HeroClasses;


public class Weapon extends Item {
    WeaponType weaponType;
    int weaponDamage;
    public Weapon(String name, int requiredLevel, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, Slot.Weapon);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }



    @Override
    public boolean ValidEquip(Hero hero) throws Exception {

            if (hero.validWeaponTypes.contains(weaponType)) {
                if (hero.level >= requiredLevel){
                    return true;
                }else{
                    throw new InvalidWeaponException("Your heros level is too low");
                }
            } else {
                throw new InvalidWeaponException("Your hero class can not use this type of weapon");
            }
    }


    }



