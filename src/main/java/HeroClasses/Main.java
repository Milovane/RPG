package HeroClasses;

public class Main {
    public static void main(String[] args) throws Exception {
      try {
          var Yasir = new Mage("") ;
        System.out.println(Yasir);
        Yasir.levelUp();
        System.out.println(Yasir);
        var armor = new Armor( "Yes Cap",2, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );


        Yasir.Equip(armor);

        System.out.println(Yasir.name);

      }
      catch(Exception error) {
          System.out.println(error.getMessage());
        }
    }

    }
