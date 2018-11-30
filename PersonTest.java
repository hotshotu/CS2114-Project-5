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
 * PersonTest tests every method in Person
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class PersonTest extends TestCase {
    private Person person1;
    private Person person2;


    /**
     * Sets up each test case
     */
    public void setUp() {
        person1 = new Person("John Doe", 1, 2, 3, "A");
        person2 = new Person("Jane Doe", 1, 2, 3, "");
    }


    /**
     * Tests the getter methods
     */
    public void testGets() {
        assertEquals("John Doe", person1.getName());
        Skills temp = new Skills(1, 2, 3);
        assertTrue(temp.equals(person1.getSkills()));
        assertEquals("A", person1.getPlanetName());
    }


    /**
     * Tests the toString method
     */
    public void testToString() {
        assertEquals("John Doe A:1 M:2 T:3 Wants: A", person1.toString());
        assertEquals("No-Planet Jane Doe A:1 M:2 T:3", person2.toString());
    }


    /**
     * Tests the equals method
     */
    public void testEquals() {
        Person personN = null;
        Object personO = new Object();
        Person person3 = new Person("John Doe", 2, 3, 4, "A");
        Person person4 = new Person("John Doe", 1, 2, 3, "");
        Person person5 = new Person("John Doe", 1, 2, 3, "A");

        assertFalse(person1.equals(personN));
        assertFalse(person1.equals(personO));
        assertFalse(person1.equals(person2));
        assertFalse(person1.equals(person3));
        assertFalse(person1.equals(person4));
        assertTrue(person1.equals(person5));
    }
}
