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
        var weapon = new Weapon("Weapon", 1, WeaponType.Staffs, 4);

        newMage.Equip(weapon);

        assertEquals(weapon, newMage.equipment.get(Slot.Weapon));
    }


    @Test
    void mageEquip_invalidWeaponType_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Weapon", 1, WeaponType.Swords, 4);

        assertThrows(InvalidWeaponException.class, () -> newMage.Equip(weapon));
    }

    @Test
    void mageEquip_invalidWeaponLevel_ExceptionToBeThrown() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Weapon", 5, WeaponType.Staffs, 4);

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
        var newMage = new Mage("Yasir");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 3, 3) );
        newMage.Equip(armor);

        assertTrue(4 == newMage.totalAttributes().Strength && 4 == newMage.totalAttributes().Dexterity &&
                11 == newMage.totalAttributes().Intelligence);
    }

    @Test
    void mageTotalAttributes_twoPiecesOfArmour_totalAttributesToBeAdded() throws Exception {
        var newMage = new Mage("Yasir");
        var armor1 = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Cloth shirt",1, Slot.Body, ArmorType.Cloth,
                new HeroAttribute(3, 3, 3) );
        newMage.Equip(armor1);
        newMage.Equip(armor2);

        assertTrue(7 == newMage.totalAttributes().Strength && 7 == newMage.totalAttributes().Dexterity &&
                14 == newMage.totalAttributes().Intelligence);
    }

    @Test
    void mageTotalAttributes_replacePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newMage = new Mage("Yasir");
        var armor1 = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 3, 3) );
        newMage.Equip(armor1);
        newMage.Equip(armor2);

        assertTrue(4 == newMage.totalAttributes().Strength && 4 == newMage.totalAttributes().Dexterity &&
                11 == newMage.totalAttributes().Intelligence);
    }

    @Test
    void mageDamage_damageWithoutWeapon_totalDamageToBeAdded() throws Exception {
        var newMage = new Mage("Yasir");

        assertTrue(1.08 == newMage.totalDamage());
    }

    @Test
    void mageDamage_damageWithWeapon_totalDamageToBeCorrect() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Staff", 1, WeaponType.Staffs, 3);

        newMage.Equip(weapon);

        assertTrue(3.24 == newMage.totalDamage());
    }

    @Test
    void mageDamage_equipNewWeapon_totalDamageBeUnaltered() throws Exception {
        var newMage = new Mage("Yasir");
        var weapon1 = new Weapon("Staff", 1, WeaponType.Staffs, 3);
        var weapon2 = new Weapon("Wand", 1, WeaponType.Wands, 3);

        newMage.Equip(weapon1);
        newMage.Equip(weapon2);

        assertTrue(3.24 == newMage.totalDamage());
    }

    @Test
    void mageDamage_equipWeaponAndArmour_totalDamageToBeCorrect() throws Exception {
        //Expected is: 3 * (1 + (11/100)) = 3.33
        var newMage = new Mage("Yasir");
        var weapon = new Weapon("Staff", 1, WeaponType.Staffs, 3);
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 3, 3) );

        newMage.Equip(weapon);
        newMage.Equip(armor);

        assertTrue(3.33 == newMage.totalDamage());
    }

    @Test
    void mageDisplay_mageHeroDisplay_displayAllStats() throws Exception {
        String expected = "Name: " + "Yasir" + "\n" + "Hero class: " + "Mage" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "1" + "\n" + "Dexterity: " + "1" + "\n" +
                "Intelligence: " + "8" + "\n" + "Hero damage: " + "1.08";
        var newMage = new Mage("Yasir");

        assertEquals(expected, newMage.HeroDisplay());
    }

    @Test
    void mageDisplay_mageHeroDisplayWithArmour_displayAllStats() throws Exception {
        String expected = "Name: " + "Yasir" + "\n" + "Hero class: " + "Mage" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "4" + "\n" + "Dexterity: " + "4" + "\n" +
                "Intelligence: " + "11" + "\n" + "Hero damage: " + "1.11";
        var newMage = new Mage("Yasir");
        var armor = new Armor( "Cloth Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 3, 3) );

        newMage.Equip(armor);

        assertEquals(expected, newMage.HeroDisplay());
    }



}