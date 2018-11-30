/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

/**
 * The exception thrown if something is wrong with the file reading
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * The constructor for the exception
     * 
     * @param string
     *            The error message
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
