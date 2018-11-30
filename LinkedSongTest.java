/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Tester for linkedSong class
 * 
 * @author Jeffrey Peng <jeffp123>
 * @version 11.15.2018
 *
 */
public class LinkedSongTest extends TestCase {
    private SongNode song1;
    private SongNode song2;
    private LinkedSong songs;


    /**
     * Sets up the required variables
     */
    public void setUp() {
        Song sing = new Song("Hello", "Adele", 2012, "Pop");
        Song sing2 = new Song("Rockstar", "Post Malone", 2016, "Rap");
        song1 = new SongNode(sing);
        song2 = new SongNode(sing2);
        songs = new LinkedSong();

    }


    /**
     * Tests the get method
     */
    public void testGet() {
        songs.add(song1);
        songs.add(song2);
        assertEquals(song1, songs.getHead());
        assertEquals(song2, songs.getTail());
        songs.add(song2);
        assertEquals(3, songs.size());
    }


    /**
     * Tests the indexOf method
     */
    public void testIndexOf() {
        songs.add(song1);
        songs.add(song2);
        try {
            songs.getIndex(5);
        }
        catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        songs.add(song2);
        assertEquals(song2, songs.getIndex(1));
        assertEquals(song2, songs.getIndex(2));
    }
}
