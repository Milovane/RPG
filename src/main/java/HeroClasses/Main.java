package HeroClasses;

public class Main {
    public static void main(String[] args) throws Exception {
          var Yasir = new Mage("Yasir") ;
        var armor = new Armor( "Yes Cap",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );
        var armor1 = new Armor( "No",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );
        var armor2 = new Armor( "Yes Cap",1, Slot.Legs, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );
        var armor3 = new Armor( "Yes Cap",1, Slot.Weapon, ArmorType.Cloth,
                new HeroAttribute(3, 4, 99) );



       Yasir.Equip(armor);
        Yasir.Equip(armor1);
        Yasir.Equip(armor2);
        Yasir.Equip(armor3);

        System.out.println(Yasir.totalAttributes());



/*
          Yasir.Equip(weapon);
          System.out.println(Yasir.equipment.get(Slot.Weapon));

          Yasir.Equip(weapon2);
          System.out.println(Yasir.equipment.get(Slot.Weapon));
*/



      }

    }


