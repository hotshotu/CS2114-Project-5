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
 * ColonyCalculatorTest tests each method in ColonyCalculator
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.25
 */
public class ColonyCalculatorTest extends TestCase {
    private ArrayQueue<Person> per1;
    private Planet[] planet1;
    private ColonyCalculator calc1;


    /**
     * Sets up each test case
     */
    public void setUp() {
        per1 = new ArrayQueue<Person>();
        per1.enqueue(new Person("A", 2, 2, 2, "A"));
        per1.enqueue(new Person("B", 2, 2, 2, "B"));
        per1.enqueue(new Person("C", 3, 3, 3, "B"));
        per1.enqueue(new Person("D", 2, 2, 2, ""));
        per1.enqueue(new Person("E", 3, 3, 3, ""));
        per1.enqueue(new Person("F", 5, 5, 5, ""));

        per1.enqueue(new Person("G", 1, 1, 1, ""));
        per1.enqueue(new Person("H", 3, 3, 3, "A"));

        per1.enqueue(new Person("RejectBus", 5, 5, 5, ""));

        planet1 = new Planet[3];
        planet1[0] = new Planet("A", 2, 2, 2, 5);
        planet1[1] = new Planet("B", 3, 3, 3, 0);
        planet1[2] = new Planet("C", 5, 5, 5, 5);

        calc1 = new ColonyCalculator(per1, planet1);
    }


    /**
     * Tests the constructor
     */
    public void testConstructor() {
        ArrayQueue<Person> perN = null;
        Planet[] planetN = null;
        Planet[] planet2 = new Planet[2];
        Planet[] planet3 = new Planet[3];

        try {
            new ColonyCalculator(perN, planet1);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            new ColonyCalculator(per1, planetN);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            new ColonyCalculator(per1, planet2);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            new ColonyCalculator(per1, planet3);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
    }


    /**
     * Tests the getter methods
     */
    public void testGets() {
        assertEquals(per1, calc1.getQueue());
        assertEquals(planet1[0].toString(), ColonyCalculator.getPlanets()[1]
            .toString());
    }


    /**
     * Tests the getPlanet and accept/reject methods
     */
    public void testGetPlanet() {
        Person personN = null;
        try {
            calc1.getPlanetForPerson(personN);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }

        assertTrue(calc1.accept());
        assertTrue(calc1.accept());
        assertTrue(calc1.accept());
        assertTrue(calc1.accept());
        assertTrue(calc1.accept());
        assertTrue(calc1.accept());

        assertFalse(calc1.accept());
        assertFalse(calc1.accept());

        calc1.reject();
        assertTrue(calc1.getQueue().isEmpty());
    }


    /**
     * Tests the PbyNum and NumbyP methods
     */
    public void testPN() {
        assertEquals("A", calc1.planetByNumber(calc1.getPlanetIndex("A"))
            .getName());
        assertEquals("B", calc1.planetByNumber(calc1.getPlanetIndex("B"))
            .getName());
        assertEquals("C", calc1.planetByNumber(calc1.getPlanetIndex("C"))
            .getName());
        assertEquals(0, calc1.getPlanetIndex(""));
        assertNull(calc1.planetByNumber(0));
        assertNull(calc1.planetByNumber(4));
    }
}
