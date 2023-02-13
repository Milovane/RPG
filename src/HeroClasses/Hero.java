package HeroClasses;

import HeroClasses.HeroAttribute;

import java.util.*;

public abstract class Hero {
    String name;
    int level;
    HeroAttribute levelAttributes;
    Map<Slot, Item> equipment = new HashMap<Slot, Item>();
    List<WeaponType> validWeaponTypes;
    List<ArmorType> validArmorTypes;

public Hero(String name) {
    this.name = name;
    this.level = 1;
    validWeaponTypes = new ArrayList<WeaponType>();
    validArmorTypes = new ArrayList<ArmorType>();
}
public abstract void levelUp();

    @Override
    public String toString() {
        return "HeroClasses.Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", levelAttributes=" + levelAttributes +
                ", validWeaponTypes=" + validWeaponTypes +
                ", validArmorTypes=" + validArmorTypes +
                '}';
    }

public void Equip(Item item) {
        if (item.ValidEquip(this)) {
            equipment.put(item.slot, item);
            System.out.println(item.name);

        }


}

}


