package HeroClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    @Test
    void rogueSetName_validName_shouldGiveRogueName() throws Exception {
        String expected = "Sean";

        var newRogue = new Rogue("Sean");

        assertEquals(expected, newRogue.name);

    }

    @Test
    void rogueSetName_tooShortName_throwErrorNameTooShort() throws Exception {
        String expected = "Name too short";

        try {
            var newRogue = new Rogue(""); //31 characters, max is 30.
        }
        catch(Exception error) {
            assertEquals(error.getMessage(), expected);
        }

    }

    @Test
    void createRogue_levelInitialization_rogueTooStartWithLevel1() throws Exception {
        var newRogue = new Rogue("Sean");

        assertEquals(1, newRogue.level); //Should start with 1

    }


    @Test
    void createRogue_statInitialization_rogueTooStartWithCorrectAttributes() throws Exception {
        var newRogue = new Rogue("Sean");

        //Strength should start with 1
        //Dexterity should start with 7
        //Intelligence should start with 1

        assertTrue(2 == newRogue.levelAttributes.Strength && 6 == newRogue.levelAttributes.Dexterity &&
                1 == newRogue.levelAttributes.Intelligence);
    }

    @Test
    void rogueLevelUp_attributeUpgrade_attributesToUpgradeForRogue() throws Exception {
        var leveledUpRogue = new Rogue("Sean");
        leveledUpRogue.levelUp();

        //Strength should increase by 1
        //Dexterity should increase by 4
        //Intelligence should increase by 1

        assertTrue(3 == leveledUpRogue.levelAttributes.Strength && 10 == leveledUpRogue.levelAttributes.Dexterity &&
                2 == leveledUpRogue.levelAttributes.Intelligence);
    }

    @Test
    void rogueLevelUp_levelIncreased_levelToBeIncreasedBy1() throws Exception {
        var leveledUpRogue = new Rogue("Sean");
        leveledUpRogue.levelUp();

        assertEquals(2, leveledUpRogue.level);

    }

    @Test
    void rogueEquip_validWeaponEquip_itemToBeEquipped() throws Exception {
        var newRogue = new Rogue("Sean");
        var weapon = new Weapon("Glock19", 1, WeaponType.Swords, 4);

        newRogue.Equip(weapon);

        assertEquals(weapon, newRogue.equipment.get(Slot.Weapon));
    }


    @Test
    void rogueEquip_invalidWeaponType_ExceptionToBeThrown() throws Exception {
        var newRogue = new Rogue("Sean");
        var weapon = new Weapon("Glock19", 1, WeaponType.Staffs, 4);

        assertThrows(InvalidWeaponException.class, () -> newRogue.Equip(weapon));
    }

    @Test
    void rogueEquip_invalidWeaponLevel_ExceptionToBeThrown() throws Exception {
        var newRogue = new Rogue("Sean");
        var weapon = new Weapon("Glock19", 5, WeaponType.Swords, 4);

        assertThrows(InvalidWeaponException.class, () -> newRogue.Equip(weapon));
    }

    @Test
    void rogueEquip_validArmorEquip_itemToBeEquipped() throws Exception {
        var newRogue = new Rogue("Sean");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 4, 5) );

        newRogue.Equip(armor);

        assertEquals(armor, newRogue.equipment.get(Slot.Head));
    }

    @Test
    void rogueEquip_invalidArmorType_ExceptionToBeThrown() throws Exception {
        var newRogue = new Rogue("Sean");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newRogue.Equip(armor));
    }

    @Test
    void rogueEquip_invalidArmorLevel_ExceptionToBeThrown() throws Exception {
        var newRogue = new Rogue("Sean");
        var armor = new Armor( "Leather Helmet",2, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newRogue.Equip(armor));
    }

    @Test
    void rogueTotalAttributes_noEquipment_totalAttributesToBeAdded() throws Exception {
        var newRogue = new Rogue("Sean");

        assertTrue(2 == newRogue.totalAttributes().Strength && 6 == newRogue.totalAttributes().Dexterity &&
                1 == newRogue.totalAttributes().Intelligence);
    }

    @Test
    void rogueTotalAttributes_onePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newRogue = new Rogue("Sean");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        newRogue.Equip(armor);

        assertTrue(5 == newRogue.totalAttributes().Strength && 9 == newRogue.totalAttributes().Dexterity &&
                4 == newRogue.totalAttributes().Intelligence);
    }

    @Test
    void rogueTotalAttributes_twoPiecesOfArmour_totalAttributesToBeAdded() throws Exception {
        var newRogue = new Rogue("Sean");
        var armor1 = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Leather shirt",1, Slot.Body, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        newRogue.Equip(armor1);
        newRogue.Equip(armor2);

        assertTrue(8 == newRogue.totalAttributes().Strength && 12 == newRogue.totalAttributes().Dexterity &&
                7 == newRogue.totalAttributes().Intelligence);
    }

    @Test
    void rogueTotalAttributes_replacePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newRogue = new Rogue("Sean");
        var armor1 = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        newRogue.Equip(armor1);
        newRogue.Equip(armor2);

        assertTrue(5 == newRogue.totalAttributes().Strength && 9 == newRogue.totalAttributes().Dexterity &&
                4 == newRogue.totalAttributes().Intelligence);
    }

    @Test
    void rogueDamage_damageWithoutWeapon_totalDamageToBeAdded() throws Exception {
        var newRogue = new Rogue("Sean");

        assertTrue(1.06 == newRogue.totalDamage());
    }

    @Test
    void rogueDamage_damageWithWeapon_totalDamageToBeCorrect() throws Exception {
        var newRogue = new Rogue("Sean");
        var weapon = new Weapon("Dagger", 1, WeaponType.Swords, 3);

        newRogue.Equip(weapon);

        assertTrue(3.18 == newRogue.totalDamage());
    }

    @Test
    void rogueDamage_equipNewWeapon_totalDamageBeUnaltered() throws Exception {
        var newRogue = new Rogue("Sean");
        var weapon1 = new Weapon("Dagger", 1, WeaponType.Swords, 3);
        var weapon2 = new Weapon("Dagger", 1, WeaponType.Swords, 3);

        newRogue.Equip(weapon1);
        newRogue.Equip(weapon2);

        assertTrue(3.18 == newRogue.totalDamage());
    }

    @Test
    void rogueDamage_equipWeaponAndArmour_totalDamageToBeCorrect() throws Exception {
        //Expected is: 3 * (1 + (9/100)) = 3.27
        var newRogue = new Rogue("Sean");
        var weapon = new Weapon("Dagger", 1, WeaponType.Swords, 3);
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );

        newRogue.Equip(weapon);
        newRogue.Equip(armor);

        assertEquals(3.27, newRogue.totalDamage());
    }

    @Test
    void rogueDisplay_rogueHeroDisplay_displayAllStats() throws Exception {
        String expected = "Name: " + "Sean" + "\n" + "Hero class: " + "Rogue" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "2" + "\n" + "Dexterity: " + "6" + "\n" +
                "Intelligence: " + "1" + "\n" + "Hero damage: " + "1.06";
        var newRogue = new Rogue("Sean");

        assertEquals(expected, newRogue.HeroDisplay());
    }

    @Test
    void rogueDisplay_rogueHeroDisplayWithArmour_displayAllStats() throws Exception {
        String expected = "Name: " + "Sean" + "\n" + "Hero class: " + "Rogue" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "5" + "\n" + "Dexterity: " + "9" + "\n" +
                "Intelligence: " + "4" + "\n" + "Hero damage: " + "1.09";
        var newRogue = new Rogue("Sean");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );

        newRogue.Equip(armor);

        assertEquals(expected, newRogue.HeroDisplay());
    }

}