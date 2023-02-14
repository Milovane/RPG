package HeroClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    void mageSetName_validName_shouldGiveMageName() throws Exception {
        String expected = "Yasir";

        var newMage = new Mage("Yasir");

        assertEquals(expected, newMage.name);

    }

    @Test
    void mageSetName_tooShortName_throwErrorNameTooShort() throws Exception {
        String expected = "Name too short";

        try {
        var newMage = new Mage(""); //31 characters, max is 30.
        }
        catch(Exception error) {
            assertEquals(error.getMessage(), expected);
        }

    }

    @Test
    void createMage_levelInitialization_mageTooStartWithLevel1() throws Exception {
        var newMage = new Mage("Yasir");

        assertEquals(1, newMage.level); //Should start with 1

    }




    @Test
    void createMage_statInitialization_mageTooStartWithCorrectAttributes() throws Exception {
        var newMage = new Mage("Yasir");

        assertEquals(1, newMage.levelAttributes.Strength); //Should start with 1
        assertEquals(1, newMage.levelAttributes.Dexterity); //Should start with 1
        assertEquals(8, newMage.levelAttributes.Intelligence); //Should start with 8


    }

    @Test
    void mageLevelUp_attributeUpgrade_attributesToUpgradeForMage() throws Exception {

        var leveledUpMage = new Mage("Yasir");
        leveledUpMage.levelUp();

        assertEquals(2, leveledUpMage.levelAttributes.Strength); //Should increase by 1
        assertEquals(2, leveledUpMage.levelAttributes.Dexterity); //Should increase by 1
        assertEquals(13, leveledUpMage.levelAttributes.Intelligence); //Should increase by 5

    }

    @Test
    void mageLevelUp_levelIncreased_levelToBeIncreasedBy1() throws Exception {
        var leveledUpMage = new Mage("Yasir");
        leveledUpMage.levelUp();

        assertEquals(2, leveledUpMage.level);

    }

    @Test
    void mageEquip_validWeaponEquip_itemToBeEquipped() throws Exception {
        var newMage = new Mage("Peyman");
        var weapon = new Weapon("Glock19", 1, WeaponType.Staffs, 4);

        newMage.Equip(weapon);

        assertEquals(weapon, newMage.equipment.get(Slot.Weapon));
    }


    @Test
    void mageEquip_invalidWeaponType_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Peyman");
        var weapon = new Weapon("Glock19", 1, WeaponType.Swords, 4);

        assertThrows(InvalidWeaponException.class, () -> newMage.Equip(weapon));
    }

    @Test
    void mageEquip_invalidWeaponLevel_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Peyman");
        var weapon = new Weapon("Glock19", 5, WeaponType.Staffs, 4);

        assertThrows(InvalidWeaponException.class, () -> newMage.Equip(weapon));
    }

    @Test
    void mageEquip_validArmorEquip_itemToBeEquipped() throws Exception {
        var newMage = new Mage("Peyman");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );

        newMage.Equip(armor);

        assertEquals(armor, newMage.equipment.get(Slot.Head));
    }

    @Test
    void mageEquip_invalidArmorType_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Peyman");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newMage.Equip(armor));
    }

    @Test
    void mageEquip_invalidArmorLevel_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Peyman");
        var armor = new Armor( "Cloth Helmet",2, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newMage.Equip(armor));
    }

    @Test
    void mageEquip_createArmourForWeaponSlot_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Peyman");

        assertThrows(InvalidArmorException.class, () -> new Armor( "Cloth Helmet",1, Slot.Weapon,
                ArmorType.Cloth, new HeroAttribute(0, 0, 0)));

    }



}