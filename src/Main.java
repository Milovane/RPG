import HeroClasses.*;

public class Main {
    public static void main(String[] args) {
       var Yasir = new Mage("Yasir") ;
        System.out.println(Yasir);
        Yasir.levelUp();
        System.out.println(Yasir);
        var armor = new Armor( "Yes Cap",2, Slot.Head, ArmorType.Cloth, new HeroAttribute(3, 4, 5) );

        Yasir.Equip(armor);



    }

    }
