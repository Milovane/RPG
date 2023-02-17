# RPG
 
This project was made with with Java for educational purposes. 
The project features basic functionality for a RPG such as diablo. The user can call methods to create their own Hero which contains a name, hero class, level, hero attributes (strength, dexterity and intelligence) and the user can also equip armour and a weapon. 

### Hero ###
The method called to create a hero is: var newMage = new mage("Name"); The different classes that can be chosen when creating a hero is: 
• Mage

• Warrior 

• Rogue 

• Ranger


When creating a hero, the level is set to 1 and the hero attributes is set to whatever the specific hero class starts with. 
To level the hero up you can call the method "Name".levelup();. This will increase the hero attributes with whatever the specific heros attributes improve with on leveling up. 

### Weapons ###
To create a weapon the method called is var weapon = new Weapon("Name", 1, WeaponType.Staffs, 4);
The different parameters that are needed are: name, requiredLevel, weapontype and weapon damage). 
The different weapon types and the hero class that can use it are:

|WeaponType|Hero|
|----|-----|
|Axes|Warrior|
|Bows|Ranger|
|Daggers|Rogues|
|Hammers|Warrior|
|Staffs|Mage|
|Swords|Warrior, Rogue|
|Wand|Mage|

### Armor ###
To create a piece of armor the method called is var armor = new Armor("Name", 1, Slot.Head, ArmorType.Cloth, new HeroAttribute(3, 3, 3));
The different parameters that are needed are: name, requiredLevel, Slot."slot", ArmorType and heroattributes). 
The different slots in which a hero may equip armor in is: head, body and legs.
The different armor types and the hero class that can use it are:
|ArmorType|Hero|
|----|-----|
|Cloth|Mage|
|Leather|Ranger, Rogue|
|Mail|Ranger, Rogue, Warrior|
|Plate|Warrior|

### Display methods ###
When a hero is created you can call methods to display the heros total attributes (Heroattributes and Armorattributes).
The method called is (heroName).totalAttributes();

You can also call a method for calculating the heros damage. The hero damage is based on this equation:  WeaponDamage * (1 + DamagingAttribute/100). If a hero has no weapon equipped, the weapon damage is set to 1. 
Damaging attribute is different for each hero class. The hero classes damaging attribute is:

|Damaging attribute|Hero|
|----|-----|
|Strength|Warrior|
|Dexterity|Ranger, Rogue|
|Intelligence|Mage|

The last display function that can be called is a method that returns a string with a heros Name
• Class
• Level
• Total strength
• Total dexterity
• Total intelligence
• Damage








