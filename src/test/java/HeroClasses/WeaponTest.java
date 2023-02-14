package HeroClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void weaponSetName_correctName_shouldSetWeaponName() {
        String expected = "Sword";
        var weapon = new Weapon("Sword", 1, WeaponType.Swords, 1);

        assertEquals(expected, weapon.name);
    }

    @Test
    void weaponSetRequiredLevel_correctRequiredLevel_shouldSetWeaponLevel() {
        int expected = 3;
        var weapon = new Weapon("Sword", 3, WeaponType.Swords, 1);

        assertEquals(expected, weapon.requiredLevel);
    }

    @Test
    void weaponSetSlot_validName_shouldGiveWeaponName() {
        int expected = 3;
        var weapon = new Weapon("Sword", 3, WeaponType.Swords, 1);

        assertEquals(expected, weapon.requiredLevel);
    }



}