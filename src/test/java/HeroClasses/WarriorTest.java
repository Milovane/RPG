package HeroClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void warriorSetName_validName_shouldGiveWarriorName() throws Exception {
        String expected = "Warren";

        var newWarrior = new Warrior("Warren");

        assertEquals(expected, newWarrior.name);

    }

    @Test
    void warriorSetName_tooShortName_throwErrorNameTooShort() throws Exception {
        String expected = "Name too short";

        try {
            var newWarrior = new Warrior(""); //31 characters, max is 30.
        }
        catch(Exception error) {
            assertEquals(error.getMessage(), expected);
        }

    }

    @Test
    void createWarrior_levelInitialization_warriorTooStartWithLevel1() throws Exception {
        var newWarrior = new Warrior("Warren");

        assertEquals(1, newWarrior.level); //Should start with 1

    }


    @Test
    void createWarrior_statInitialization_warriorTooStartWithCorrectAttributes() throws Exception {
        var newWarrior = new Warrior("Warren");

        //Strength should start with 5
        //Dexterity should start with 2
        //Intelligence should start with 1

        assertTrue(5 == newWarrior.levelAttributes.Strength && 2 == newWarrior.levelAttributes.Dexterity &&
                1 == newWarrior.levelAttributes.Intelligence);
    }

    @Test
    void warriorLevelUp_attributeUpgrade_attributesToUpgradeForWarrior() throws Exception {
        var leveledUpWarrior = new Warrior("Warren");
        leveledUpWarrior.levelUp();

        //Strength should increase by 3
        //Dexterity should increase by 2
        //Intelligence should increase by 1

        assertTrue(8 == leveledUpWarrior.levelAttributes.Strength && 4 == leveledUpWarrior.levelAttributes.Dexterity &&
                2 == leveledUpWarrior.levelAttributes.Intelligence);
    }

    @Test
    void warriorLevelUp_levelIncreased_levelToBeIncreasedBy1() throws Exception {
        var leveledUpWarrior = new Warrior("Warren");
        leveledUpWarrior.levelUp();

        assertEquals(2, leveledUpWarrior.level);

    }

    @Test
    void warriorEquip_validWeaponEquip_itemToBeEquipped() throws Exception {
        var newWarrior = new Warrior("Warren");
        var weapon = new Weapon("Glock19", 1, WeaponType.Swords, 4);

        newWarrior.Equip(weapon);

        assertEquals(weapon, newWarrior.equipment.get(Slot.Weapon));
    }


    @Test
    void warriorEquip_invalidWeaponType_ExceptionToBeThrown() throws Exception {
        var newWarrior = new Warrior("Warren");
        var weapon = new Weapon("Glock19", 1, WeaponType.Staffs, 4);

        assertThrows(InvalidWeaponException.class, () -> newWarrior.Equip(weapon));
    }

    @Test
    void warriorEquip_invalidWeaponLevel_ExceptionToBeThrown() throws Exception {
        var newWarrior = new Warrior("Warren");
        var weapon = new Weapon("Glock19", 5, WeaponType.Swords, 4);

        assertThrows(InvalidWeaponException.class, () -> newWarrior.Equip(weapon));
    }

    @Test
    void warriorEquip_validArmorEquip_itemToBeEquipped() throws Exception {
        var newWarrior = new Warrior("Warren");
        var armor = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 4, 5) );

        newWarrior.Equip(armor);

        assertEquals(armor, newWarrior.equipment.get(Slot.Head));
    }

    @Test
    void warriorEquip_invalidArmorType_ExceptionToBeThrown() throws Exception {
        var newWarrior = new Warrior("Warren");
        var armor = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Cloth,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newWarrior.Equip(armor));
    }

    @Test
    void warriorEquip_invalidArmorLevel_ExceptionToBeThrown() throws Exception {
        var newWarrior = new Warrior("Warren");
        var armor = new Armor( "Plate Helmet",2, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 4, 5) );

        assertThrows(InvalidArmorException.class, () -> newWarrior.Equip(armor));
    }

    @Test
    void warriorTotalAttributes_noEquipment_totalAttributesToBeAdded() throws Exception {
        var newWarrior = new Warrior("Warren");

        assertTrue(5 == newWarrior.totalAttributes().Strength && 2 == newWarrior.totalAttributes().Dexterity &&
                1 == newWarrior.totalAttributes().Intelligence);
    }

    @Test
    void warriorTotalAttributes_onePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newWarrior = new Warrior("Warren");
        var armor = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );
        newWarrior.Equip(armor);

        assertTrue(8 == newWarrior.totalAttributes().Strength && 5 == newWarrior.totalAttributes().Dexterity &&
                4 == newWarrior.totalAttributes().Intelligence);
    }

    @Test
    void warriorTotalAttributes_twoPiecesOfArmour_totalAttributesToBeAdded() throws Exception {
        var newWarrior = new Warrior("Warren");
        var armor1 = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Plate shirt",1, Slot.Body, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );
        newWarrior.Equip(armor1);
        newWarrior.Equip(armor2);

        assertTrue(11 == newWarrior.totalAttributes().Strength && 8 == newWarrior.totalAttributes().Dexterity &&
                7 == newWarrior.totalAttributes().Intelligence);
    }

    @Test
    void warriorTotalAttributes_replacePieceOfArmour_totalAttributesToBeAdded() throws Exception {
        var newWarrior = new Warrior("Warren");
        var armor1 = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );
        var armor2 = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );
        newWarrior.Equip(armor1);
        newWarrior.Equip(armor2);

        assertTrue(8 == newWarrior.totalAttributes().Strength && 5 == newWarrior.totalAttributes().Dexterity &&
                4 == newWarrior.totalAttributes().Intelligence);
    }

    @Test
    void warriorDamage_damageWithoutWeapon_totalDamageToBeAdded() throws Exception {
        var newWarrior = new Warrior("Warren");

        assertTrue(1.05 == newWarrior.totalDamage());
    }

    @Test
    void warriorDamage_damageWithWeapon_totalDamageToBeCorrect() throws Exception {
        var newWarrior = new Warrior("Warren");
        var weapon = new Weapon("Dagger", 1, WeaponType.Swords, 3);

        newWarrior.Equip(weapon);

        assertTrue(3.15 == newWarrior.totalDamage());
    }

    @Test
    void warriorDamage_equipNewWeapon_totalDamageBeUnaltered() throws Exception {
        var newWarrior = new Warrior("Warren");
        var weapon1 = new Weapon("Dagger", 1, WeaponType.Swords, 3);
        var weapon2 = new Weapon("Dagger", 1, WeaponType.Swords, 3);

        newWarrior.Equip(weapon1);
        newWarrior.Equip(weapon2);

        assertTrue(3.15 == newWarrior.totalDamage());
    }

    @Test
    void warriorDamage_equipWeaponAndArmour_totalDamageToBeCorrect() throws Exception {
        //Expected is: 3 * (1 + (8/100)) = 3.27
        var newWarrior = new Warrior("Warren");
        var weapon = new Weapon("Dagger", 1, WeaponType.Swords, 3);
        var armor = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );

        newWarrior.Equip(weapon);
        newWarrior.Equip(armor);

        assertEquals(3.24, newWarrior.totalDamage());
    }

    @Test
    void warriorDisplay_warriorHeroDisplay_displayAllStats() throws Exception {
        String expected = "Name: " + "Warren" + "\n" + "Hero class: " + "Warrior" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "5" + "\n" + "Dexterity: " + "2" + "\n" +
                "Intelligence: " + "1" + "\n" + "Hero damage: " + "1.05";
        var newWarrior = new Warrior("Warren");

        assertEquals(expected, newWarrior.HeroDisplay());
    }

    @Test
    void warriorDisplay_warriorHeroDisplayWithArmour_displayAllStats() throws Exception {
        String expected = "Name: " + "Warren" + "\n" + "Hero class: " + "Warrior" + "\n" + "Level: " + "1" + "\n" +
                "Strength: " + "8" + "\n" + "Dexterity: " + "5" + "\n" +
                "Intelligence: " + "4" + "\n" + "Hero damage: " + "1.08";
        var newWarrior = new Warrior("Warren");
        var armor = new Armor( "Plate Helmet",1, Slot.Head, ArmorType.Plate,
                new HeroAttribute(3, 3, 3) );

        newWarrior.Equip(armor);

        assertEquals(expected, newWarrior.HeroDisplay());
    }

}