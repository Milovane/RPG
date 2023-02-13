package HeroClasses;

public class Armor extends Item {
    ArmorType armorType;

    @Override
    public String toString() {
        return "Armor{" +
                "armorType=" + armorType +
                ", ArmorAttribute=" + ArmorAttribute +
                '}';
    }

    HeroAttribute ArmorAttribute;
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute ArmorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.ArmorAttribute = ArmorAttribute;
    }

    @Override
    public boolean ValidEquip(Hero hero) {
        if (hero.validArmorTypes.contains(armorType) && hero.level >= requiredLevel)
            return true;

            return false;


    }
}
