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
 * PlanetTest tests every method in Planet
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class PlanetTest extends TestCase {
    private Planet p1;
    private Person per1;


    /**
     * Sets up each test case
     */
    public void setUp() {
        p1 = new Planet("A", 2, 2, 2, 10);
        per1 = new Person("A", 2, 3, 4, "");
        p1.addPerson(per1);
    }


    /**
     * Tests the getter, setter, and toString methods
     */
    public void testCommonMethods() {
        assertEquals("A", p1.getName());
        p1.setName("B");
        assertEquals("B", p1.getName());
        assertEquals("A:2 M:2 T:2", p1.getSkills().toString());
        assertEquals("A", p1.getPopulation()[0].getName());
        assertEquals(1, p1.getPopulationSize());
        assertEquals(10, p1.getCapacity());
        assertEquals(9, p1.getAvailability());
        assertFalse(p1.isFull());
        assertEquals(
            "B, population 1 (cap: 10), Requires: A >= 2, M >= 2, T >= 2", p1
                .toString());
    }


    /**
     * Tests the add and isQualified methods
     */
    public void testAdd() {
        Person perN = null;
        assertFalse(p1.addPerson(perN));
        assertFalse(p1.addPerson(new Person("A", 1, 3, 3, "")));
        assertFalse(p1.addPerson(new Person("A", 3, 1, 3, "")));
        assertFalse(p1.addPerson(new Person("A", 3, 3, 1, "")));

        for (int i = 0; i < 9; i++) {
            assertTrue(p1.addPerson(per1));
        }
        assertFalse(p1.addPerson(per1));
        assertFalse(p1.isQualified(perN));
    }


    /**
     * Tests the equals and compareTo methods
     */
    public void testComp() {
        Planet pN = null;
        Object pO = new Object();
        Planet p2 = new Planet("B", 2, 2, 2, 10);
        Planet p3 = new Planet("A", 1, 1, 1, 10);
        Planet p4 = new Planet("A", 2, 2, 2, 9);
        Planet p5 = new Planet("A", 2, 2, 2, 10);
        p5.addPerson(per1);

        assertFalse(p1.equals(pN));
        assertFalse(p1.equals(pO));
        assertFalse(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertTrue(p1.equals(p5));

        assertEquals(-1, p1.compareTo(p2));
        p2.addPerson(per1);
        assertEquals(0, p1.compareTo(p2));
        p2.addPerson(per1);
        assertEquals(1, p1.compareTo(p2));
    }
}
