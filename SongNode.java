package prj5;

/**
 * SongNode is our Node implementation that holds a song
 * 
 * @author Ender Jaska
 * @version 2018.11.10
 */
public class SongNode {

    private Song data;
    private SongNode next;


    /**
     * Constructor for SongNode
     * 
     * @param entry
     *            The song to be stored
     */
    public SongNode(Song entry) {
        data = entry;
        next = null;
    }


    /**
     * Getter method for the song
     * 
     * @return Returns the stored song
     */
    public Song getData() {
        return data;
    }


    /**
     * Getter method for the next SongNode
     * 
     * @return Returns the next SongNode
     */
    public SongNode getNext() {
        return next;
    }


    /**
     * Setter method for the next SongNode. Used in sorting.
     * 
     * @param entry
     *            The new next SongNode
     */
    public void setNext(SongNode entry) {
        next = entry;
    }


    /**
     * Setter method to change data
     * 
     * @param song
     *            The new song
     */
    public void setData(Song song) {
        data = song;
    }
}
