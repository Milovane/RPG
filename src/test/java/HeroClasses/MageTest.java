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
    void createMage_statInitializaion_mageTooStartWithCorrectAttributes() throws Exception {
        var newMage = new Mage("Yasir");

        assertEquals(1, newMage.levelAttributes.Strength); //Should start with 1
        assertEquals(1, newMage.levelAttributes.Dexterity); //Should start with 1
        assertEquals(8, newMage.levelAttributes.Intelligence); //Should start with 8


    }

    @Test
    void mageLevelUp_attributeUpgrade_attributesToUpgradeForMage() throws Exception {

        var leveledUpMage = new Mage("Peyman");
        leveledUpMage.levelUp();

        assertEquals(2, leveledUpMage.levelAttributes.Strength); //Should increase by 1
        assertEquals(2, leveledUpMage.levelAttributes.Dexterity); //Should increase by 1
        assertEquals(13, leveledUpMage.levelAttributes.Intelligence); //Should increase by 5

    }

    @Test
    void mageLevelUp_levelIncreased_levelToBeIncreasedBy1() throws Exception {
        var leveledUpMage = new Mage("Peyman");
        leveledUpMage.levelUp();

        assertEquals(2, leveledUpMage.level);

    }

    @Test
    void mageEquip_validEquip_itemToBeEquipped() {
        var newMage = new Mage("Yasir");


    }

            //Need test for weapon and armor exceptions

}