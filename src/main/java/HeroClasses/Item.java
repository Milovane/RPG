package HeroClasses;

//Parent class to weapon and armor.
public abstract class Item {
    String name;
    int requiredLevel;
    Slot slot;


    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public abstract boolean ValidEquip(Hero hero) throws Exception;

}
