package HeroClasses;

import HeroClasses.HeroAttribute;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {
    String name;
    int level;
    HeroAttribute levelAttributes;
    Map<Slot, Item> equipment = new HashMap<Slot, Item>();
    List<String> validWeaponTypes;
    List<String> validArmorTypes;

public Hero(String name) {
    this.name = name;
    this.level = 1;

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
        if (item.ValidEquip(this));

}

}


