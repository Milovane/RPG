package HeroClasses;

import HeroClasses.HeroAttribute;

import java.util.*;

public abstract class Hero {
    String name;
    String heroClass;
    int level;
    HeroAttribute levelAttributes;
    Map<Slot, Item> equipment = new HashMap<Slot, Item>();
    List<WeaponType> validWeaponTypes;
    List<ArmorType> validArmorTypes;

public Hero(String name) throws Exception {
    if (name.length()==0) {
        throw new Exception("Name too short");
    }
    this.name = name;
    this.level = 1;
    validWeaponTypes = new ArrayList<WeaponType>();
    validArmorTypes = new ArrayList<ArmorType>();
}
public abstract void levelUp();

public HeroAttribute totalAttributes() {
    HeroAttribute totalStats = new HeroAttribute(levelAttributes.Strength,levelAttributes.Dexterity,levelAttributes.Intelligence);
    for (Item i : equipment.values()) {
        if (i.slot != Slot.Weapon) {
        var cast = (Armor)i;
        if(cast != null);
        totalStats.Strength += cast.ArmorAttribute.getStrength();
        totalStats.Dexterity += cast.ArmorAttribute.getDexterity();
        totalStats.Intelligence += cast.ArmorAttribute.getIntelligence();
        }
    }
    return totalStats;
    }

    public abstract int totalDamage();






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

public void Equip(Item item) throws Exception {
        if (item.ValidEquip(this)) {
            equipment.put(item.slot, item);
        }
}

public String HeroDisplay() {
    String heroState = "Name: " + name + "\n" + "Hero class: " + heroClass + "\n" + "Level: " + level + "\n" +
           "Strength: " + totalAttributes().Strength + "\n" + "Dexterity: " + totalAttributes().Dexterity + "\n" +
            "Intelligence: " + totalAttributes().Intelligence + "\n" + "Hero damage: " + totalDamage();


    return heroState;
}

}


