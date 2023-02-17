package HeroClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    void armorSetName_correctName_shouldSetArmorName() throws Exception {
        String expected = "Helmet";
        var armor = new Armor("Helmet", 1, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5));

        assertEquals(expected, armor.name);
    }

    @Test
    void armorSetRequiredLevel_correctRequiredLevel_shouldSetArmorLevel() throws Exception {
        int expected = 3;
        var armor = new Armor("Helmet", 3, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5));

        assertEquals(expected, armor.requiredLevel);
    }

    @Test
    void armorSetSlot_correctSlot_shouldSetCorrectSlot() throws Exception {
        Slot expected = Slot.Head;
        var armor = new Armor("Helmet", 3, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5));

        assertEquals(expected, armor.slot);
    }


    @Test
    void armorSetType_correctType_shouldSetCorrectType() throws Exception {
        ArmorType expected = ArmorType.Cloth;
        var armor = new Armor("Helmet", 3, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5));

        assertEquals(expected, armor.armorType);
    }

    @Test
    void armorSetAttributes_correctAttributes_shouldSetAttributes() throws Exception {
        HeroAttribute expected = new HeroAttribute(3, 4, 5);
        var armor = new Armor("Helmet", 3, Slot.Head, ArmorType.Cloth,
                    new HeroAttribute(3, 4, 5));

        assertTrue(expected.Strength == armor.ArmorAttribute.Strength &&
                expected.Dexterity == armor.ArmorAttribute.Dexterity &&
                expected.Intelligence == armor.ArmorAttribute.Intelligence);
    }

    @Test
    void testCreateArmour_createArmourForWeaponSlot_ExceptionToBeThrown() throws Exception {

        assertThrows(InvalidArmorException.class, () -> new Armor( "Cloth Helmet",1, Slot.Weapon,
                ArmorType.Cloth, new HeroAttribute(1, 1, 1)));

    }
}