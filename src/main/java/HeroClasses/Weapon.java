package HeroClasses;


public class Weapon extends Item {
    WeaponType weaponType;
    double weaponDamage;

    //Method used to create an item which is a weapon. Unlike the armor method, the slot is set to weapon at the moment
    //of creation since a weapon may not be equipped anywhere else.
    public Weapon(String name, int requiredLevel, WeaponType weaponType, double weaponDamage) {
        super(name, requiredLevel, Slot.Weapon);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    //Method called when the equip method is used for a weapon. Checks if the Hero has the required level and
    //if the hero may use the selected weapon type.
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



