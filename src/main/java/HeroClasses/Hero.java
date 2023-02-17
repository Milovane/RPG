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

    //Method used to create a hero . An exception is thrown if name is empty.
public Hero(String name) throws Exception {
    if (name.length()==0) {
        throw new Exception("Name too short");
    }
    this.name = name;
    this.level = 1;
    validWeaponTypes = new ArrayList<WeaponType>();
    validArmorTypes = new ArrayList<ArmorType>();
}

//Method used to level up a hero
public abstract void levelUp();

//Method used to calculate a heros total attributes with equipment
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

    //Method used to calculate a heros total damage
    public abstract double totalDamage();

//Method used to equip an item to a hero.
// Before equipping the ValidEquip method is called to check if the hero may use the item in question
public void Equip(Item item) throws Exception {
        if (item.ValidEquip(this)) {
            equipment.put(item.slot, item);
        }
}

//Method to create a string which showcases the state of the hero.
public String HeroDisplay() {
    String heroState = "Name: " + name + "\n" + "Hero class: " + heroClass + "\n" + "Level: " + level + "\n" +
           "Strength: " + totalAttributes().Strength + "\n" + "Dexterity: " + totalAttributes().Dexterity + "\n" +
            "Intelligence: " + totalAttributes().Intelligence + "\n" + "Hero damage: " + totalDamage();
    return heroState;
}

}


