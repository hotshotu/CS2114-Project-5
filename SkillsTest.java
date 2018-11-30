/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

import student.TestCase;

/**
 * SkillsTest tests every method in Skills
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class SkillsTest extends TestCase {
    private Skills skill1;
    private Skills skill2;
    private Skills skill3;
    private Skills skill4;
    private Skills skillN;


    /**
     * Sets up each test case
     */
    public void setUp() {
        skill1 = new Skills(1, 2, 3);
        skill2 = new Skills(2, 3, 4);
        skill3 = new Skills(2, 4, 4);
        skill4 = new Skills(2, 3, 5);
        skillN = null;
    }


    /**
     * Tests the getter methods
     */
    public void testGets() {
        assertEquals(1, skill1.getAgriculture());
        assertEquals(2, skill1.getMedicine());
        assertEquals(3, skill1.getTechnology());
    }


    /**
     * Tests the isBelow method
     */
    public void testIsBelow() {
        assertTrue(skill1.isBelow(skill2));
        assertFalse(skill2.isBelow(skill1));
        assertFalse(skill3.isBelow(skill2));
        assertFalse(skill4.isBelow(skill2));

        try {
            skill1.isBelow(skillN);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
    }


    /**
     * Tests the toString method
     */
    public void testToString() {
        assertEquals("A:1 M:2 T:3", skill1.toString());
        assertEquals("A:2 M:3 T:4", skill2.toString());
    }


    /**
     * Tests the equals method
     */
    public void testEquals() {
        Object skillO = new Object();

        assertFalse(skill1.equals(skillN));
        assertFalse(skill1.equals(skillO));
        assertFalse(skill2.equals(skill1));
        assertFalse(skill2.equals(skill3));
        assertFalse(skill2.equals(skill4));
        assertTrue(skill2.equals(skill2));
    }
}
