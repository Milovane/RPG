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

        //Strength should start with 1
        //Dexterity should start with 1
        //Intelligence should start with 8

        assertTrue(1 == newMage.levelAttributes.Strength && 1 == newMage.levelAttributes.Dexterity &&
                8 == newMage.levelAttributes.Intelligence);
    }

    @Test
    void mageLevelUp_attributeUpgrade_attributesToUpgradeForMage() throws Exception {
        var leveledUpMage = new Mage("Yasir");
        leveledUpMage.levelUp();

        //Strength should increase by 1
        //Dexterity should increase by 1
        //Intelligence should increase by 5

        assertTrue(2 == leveledUpMage.levelAttributes.Strength && 2 == leveledUpMage.levelAttributes.Dexterity &&
                13 == leveledUpMage.levelAttributes.Intelligence);
    }

    @Test
    void mageLevelUp_levelIncreased_levelToBeIncreasedBy1() throws Exception {
        var leveledUpMage = new Mage("Yasir");
        leveledUpMage.levelUp();

        assertEquals(2, leveledUpMage.level);

    }

    @Test
    void mageEquip_validWeaponEquip_itemToBeEquipped() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Glock19", 1, WeaponType.Staffs, 4);

        newMage.Equip(weapon);

        assertEquals(weapon, newMage.equipment.get(Slot.Weapon));
    }


    @Test
    void mageEquip_invalidWeaponType_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Glock19", 1, WeaponType.Swords, 4);

        assertThrows(InvalidWeaponException.class, () -> newMage.Equip(weapon));
    }

    @Test
    void mageEquip_invalidWeaponLevel_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Glock19", 5, WeaponType.Staffs, 4);

        assertThrows(InvalidWeaponException.class, () -> newMage.Equip(weapon));
    }

    @Test
    void mageEquip_validArmorEquip_itemToBeEquipped() throws Exception {
        var newMage = new Mage("Yasir");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5) );

        newMage.Equip(armor);

        assertEquals(armor, newMage.equipment.get(Slot.Head));
    }

    @Test
    void mageEquip_invalidArmorType_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Yasir");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Plate,
                    new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newMage.Equip(armor));
    }

    @Test
    void mageEquip_invalidArmorLevel_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Yasir");
        var armor = new Armor( "Cloth Helmet",2, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newMage.Equip(armor));
    }

    @Test
    void mageTotalAttributes_noEquipment_totalAttributesToBeAdded() throws Exception {
        var newMage = new Mage("Yasir");

        assertTrue(1 == newMage.totalAttributes().Strength && 1 == newMage.totalAttributes().Dexterity &&
                8 == newMage.totalAttributes().Intelligence);
    }

    @Test
    void mageTotalAttributes_onePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        HeroAttribute expected = new HeroAttribute(4, 4, 11);
        var newMage = new Mage("Yasir");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Plate,
                    new HeroAttribute(3, 3, 3) );





        assertTrue(4 == newMage.totalAttributes().Strength && 1 == newMage.totalAttributes().Dexterity &&
                8 == newMage.totalAttributes().Intelligence);

    }


}