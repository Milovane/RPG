package HeroClasses;

public class Armor extends Item {
    ArmorType armorType;
    HeroAttribute ArmorAttribute;
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute ArmorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.ArmorAttribute = ArmorAttribute;
    }

    @Override
    public boolean ValidEquip(Hero hero) {
        return false;
    }
}
