package HeroClasses;

//This exception is thrown everytime a hero may not wear a certain piece of armor
public class InvalidArmorException extends Exception{

    public InvalidArmorException(String s) {
        super(s);

}
}
