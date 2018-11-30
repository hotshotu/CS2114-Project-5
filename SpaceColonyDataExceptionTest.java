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
 * Tests the SpaceColonyDataException
 * 
 * @author Ender Jaska
 * @version 2018.11.28
 */
public class SpaceColonyDataExceptionTest extends TestCase {
    /**
     * Sets up the case;
     */
    public void setUp() {
        /**
         * Nothing to set up
         */
    }


    /**
     * Tests the constructor
     */
    public void testC() {
        SpaceColonyDataException e = new SpaceColonyDataException("test");
        assertNotNull(e);
        assertTrue(e instanceof SpaceColonyDataException);
    }
}
