package HeroClasses;

public abstract class Item {
    String name;
    int requiredLevel;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", requiredLevel=" + requiredLevel +
                ", slot=" + slot +
                '}';
    }

    Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }


    public abstract boolean ValidEquip(Hero hero) throws Exception;

}
