package HeroClasses;

//The class of hero attributes is used everytime we need to create an object that is dependenent on different attributes.
//These are: strength, dexterity and intelligence
public class HeroAttribute {
    int Strength;
    int Dexterity;
    int Intelligence;

    public int getStrength() {
        return Strength;
    }
    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getDexterity() {
        return Dexterity;
    }
    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getIntelligence() {
        return Intelligence;
    }
    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        Strength = strength;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }
}
