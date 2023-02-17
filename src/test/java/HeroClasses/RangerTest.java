package HeroClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    @Test
    void rangerSetName_validName_shouldGiveRangerName() throws Exception {
        String expected = "Peyman";

        var newRanger = new Ranger("Peyman");

        assertEquals(expected, newRanger.name);

    }

    @Test
    void rangerSetName_tooShortName_throwErrorNameTooShort() throws Exception {
        String expected = "Name too short";

        try {
            var newRanger = new Ranger(""); //31 characters, max is 30.
        }
        catch(Exception error) {
            assertEquals(error.getMessage(), expected);
        }

    }

    @Test
    void createRanger_levelInitialization_rangerTooStartWithLevel1() throws Exception {
        var newRanger = new Ranger("Peyman");

        assertEquals(1, newRanger.level); //Should start with 1

    }


    @Test
    void createRanger_statInitialization_rangerTooStartWithCorrectAttributes() throws Exception {
        var newRanger = new Ranger("Peyman");

        //Strength should start with 1
        //Dexterity should start with 7
        //Intelligence should start with 1

        assertTrue(1 == newRanger.levelAttributes.Strength && 7 == newRanger.levelAttributes.Dexterity &&
                1 == newRanger.levelAttributes.Intelligence);
    }

    @Test
    void rangerLevelUp_attributeUpgrade_attributesToUpgradeForRanger() throws Exception {
        var leveledUpRanger = new Ranger("Peyman");
        leveledUpRanger.levelUp();

        //Strength should increase by 1
        //Dexterity should increase by 5
        //Intelligence should increase by 1

        assertTrue(2 == leveledUpRanger.levelAttributes.Strength && 12 == leveledUpRanger.levelAttributes.Dexterity &&
                2 == leveledUpRanger.levelAttributes.Intelligence);
    }

    @Test
    void rangerLevelUp_levelIncreased_levelToBeIncreasedBy1() throws Exception {
        var leveledUpRanger = new Ranger("Peyman");
        leveledUpRanger.levelUp();

        assertEquals(2, leveledUpRanger.level);

    }

    @Test
    void rangerEquip_validWeaponEquip_itemToBeEquipped() throws Exception {
        var newRanger = new Ranger("Peyman");
        var weapon = new Weapon("Weapon", 1, WeaponType.Bows, 4);

        newRanger.Equip(weapon);

        assertEquals(weapon, newRanger.equipment.get(Slot.Weapon));
    }


    @Test
    void rangerEquip_invalidWeaponType_ExceptionToBeThrown() throws Exception {
        var newRanger = new Ranger("Peyman");
        var weapon = new Weapon("Weapon", 1, WeaponType.Swords, 4);

        assertThrows(InvalidWeaponException.class, () -> newRanger.Equip(weapon));
    }

    @Test
    void rangerEquip_invalidWeaponLevel_ExceptionToBeThrown() throws Exception {
        var newRanger = new Ranger("Peyman");
        var weapon = new Weapon("Weapon", 5, WeaponType.Bows, 4);

        assertThrows(InvalidWeaponException.class, () -> newRanger.Equip(weapon));
    }

    @Test
    void rangerEquip_validArmorEquip_itemToBeEquipped() throws Exception {
        var newRanger = new Ranger("Peyman");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 4, 5) );

        newRanger.Equip(armor);

        assertEquals(armor, newRanger.equipment.get(Slot.Head));
    }

    @Test
    void rangerEquip_invalidArmorType_ExceptionToBeThrown() throws Exception {
        var newRanger = new Ranger("Peyman");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newRanger.Equip(armor));
    }

    @Test
    void rangerEquip_invalidArmorLevel_ExceptionToBeThrown() throws Exception {
        var newRanger = new Ranger("Peyman");
        var armor = new Armor( "Leather Helmet",2, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newRanger.Equip(armor));
    }

    @Test
    void rangerTotalAttributes_noEquipment_totalAttributesToBeAdded() throws Exception {
        var newRanger = new Ranger("Peyman");

        assertTrue(1 == newRanger.totalAttributes().Strength && 7 == newRanger.totalAttributes().Dexterity &&
                1 == newRanger.totalAttributes().Intelligence);
    }

    @Test
    void rangerTotalAttributes_onePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newRanger = new Ranger("Peyman");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        newRanger.Equip(armor);

        assertTrue(4 == newRanger.totalAttributes().Strength && 10 == newRanger.totalAttributes().Dexterity &&
                4 == newRanger.totalAttributes().Intelligence);
    }

    @Test
    void rangerTotalAttributes_twoPiecesOfArmour_totalAttributesToBeAdded() throws Exception {
        var newRanger = new Ranger("Peyman");
        var armor1 = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Leather shirt",1, Slot.Body, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        newRanger.Equip(armor1);
        newRanger.Equip(armor2);

        assertTrue(7 == newRanger.totalAttributes().Strength && 13 == newRanger.totalAttributes().Dexterity &&
                7 == newRanger.totalAttributes().Intelligence);
    }

    @Test
    void rangerTotalAttributes_replacePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newRanger = new Ranger("Peyman");
        var armor1 = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );
        newRanger.Equip(armor1);
        newRanger.Equip(armor2);

        assertTrue(4 == newRanger.totalAttributes().Strength && 10 == newRanger.totalAttributes().Dexterity &&
                4 == newRanger.totalAttributes().Intelligence);
    }

    @Test
    void rangerDamage_damageWithoutWeapon_totalDamageToBeAdded() throws Exception {
        var newRanger = new Ranger("Peyman");

        assertTrue(1.07 == newRanger.totalDamage());
    }

    @Test
    void rangerDamage_damageWithWeapon_totalDamageToBeCorrect() throws Exception {
        var newRanger = new Ranger("Peyman");
        var weapon = new Weapon("Bows", 1, WeaponType.Bows, 3);

        newRanger.Equip(weapon);

        assertTrue(3.21 == newRanger.totalDamage());
    }

    @Test
    void rangerDamage_equipNewWeapon_totalDamageBeUnaltered() throws Exception {
        var newRanger = new Ranger("Peyman");
        var weapon1 = new Weapon("Bows", 1, WeaponType.Bows, 3);
        var weapon2 = new Weapon("Bows", 1, WeaponType.Bows, 3);

        newRanger.Equip(weapon1);
        newRanger.Equip(weapon2);

        assertTrue(3.21 == newRanger.totalDamage());
    }

    @Test
    void rangerDamage_equipWeaponAndArmour_totalDamageToBeCorrect() throws Exception {
        //Expected is: 3 * (1 + (10/100)) = 3.3
        var newRanger = new Ranger("Peyman");
        var weapon = new Weapon("Bows", 1, WeaponType.Bows, 3);
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );

        newRanger.Equip(weapon);
        newRanger.Equip(armor);

        assertEquals(3.3, newRanger.totalDamage());
    }

    @Test
    void rangerDisplay_rangerHeroDisplay_displayAllStats() throws Exception {
        String expected = "Name: " + "Peyman" + "\n" + "Hero class: " + "Ranger" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "1" + "\n" + "Dexterity: " + "7" + "\n" +
                "Intelligence: " + "1" + "\n" + "Hero damage: " + "1.07";
        var newRanger = new Ranger("Peyman");

        assertEquals(expected, newRanger.HeroDisplay());
    }

    @Test
    void rangerDisplay_rangerHeroDisplayWithArmour_displayAllStats() throws Exception {
        String expected = "Name: " + "Peyman" + "\n" + "Hero class: " + "Ranger" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "4" + "\n" + "Dexterity: " + "10" + "\n" +
                "Intelligence: " + "4" + "\n" + "Hero damage: " + "1.1";
        var newRanger = new Ranger("Peyman");
        var armor = new Armor( "Leather Helmet",1, Slot.Head, ArmorType.Leather,
                new HeroAttribute(3, 3, 3) );

        newRanger.Equip(armor);

        assertEquals(expected, newRanger.HeroDisplay());
    }

}