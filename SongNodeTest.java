/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Tester for songNode class
 * 
 * @author Jeffrey Peng <jeffp123>
 * @version 11.15.2018
 *
 */
public class SongNodeTest extends TestCase {

    private SongNode song1;
    private SongNode song2;
    private Song sing;
    private Song sing2;


    /**
     * Sets up required variables
     */
    public void setUp() {
        sing = new Song("Hello", "Adele", 2012, "Pop");
        sing2 = new Song("Rockstar", "Post Malone", 2016, "Rap");
        song1 = new SongNode(sing);
        song2 = new SongNode(sing2);
    }


    /**
     * Tests the get and set methods
     */
    public void testGetSet() {
        assertEquals(sing, song1.getData());
        assertEquals(sing2, song2.getData());
        song1.setNext(song2);
        assertEquals(song2, song1.getNext());
        song2.setNext(song1);
    }
}
