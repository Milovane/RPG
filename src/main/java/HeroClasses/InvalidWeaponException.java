package HeroClasses;

//This exception is thrown everytime a hero may not use a certain weapon

public class InvalidWeaponException extends Exception {

    public InvalidWeaponException(String s) {
        super(s);

    }
}
