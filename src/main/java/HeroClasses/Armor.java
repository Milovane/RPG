package HeroClasses;

public class Armor extends Item {
    ArmorType armorType;

    HeroAttribute ArmorAttribute;
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute ArmorAttribute) throws Exception {
        super(name, requiredLevel, slot);
        if (slot == Slot.Weapon)  {
            throw new InvalidArmorException("Armour cant be used as weapon");
        }
        this.armorType = armorType;
        this.ArmorAttribute = ArmorAttribute;
    }

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
