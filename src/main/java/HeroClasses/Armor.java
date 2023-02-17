package HeroClasses;

public class Armor extends Item {
    ArmorType armorType;
    HeroAttribute ArmorAttribute;

    //Method used to create an item which is an armor. When creating an armor a slot needs to be designated.
    //If the slot is weapon, an exception is thrown.
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute ArmorAttribute) throws Exception {
        super(name, requiredLevel, slot);
        if (slot == Slot.Weapon)  {
            throw new InvalidArmorException("Armour cant be used as weapon");
        }
        this.armorType = armorType;
        this.ArmorAttribute = ArmorAttribute;
    }

    //Method called when the equip method is used for an armor. Checks if the Hero has the required level and
    //if the hero can wear the selected armor type.
    @Override
    public boolean ValidEquip(Hero hero) throws Exception {

            if (hero.validArmorTypes.contains(armorType)) {
                if (hero.level >= requiredLevel){
                    return true;
                }else{
                    throw new InvalidArmorException("Your heros level is too low");
                }
            } else {
                throw new InvalidArmorException("Your hero class can not wear this type of armor");
        }
    }
}
