package prj5;

/**
 * Class for LinkedSong
 * 
 * @author Kenneth Ding <dkenny>
 * @version 11.14.2018
 *
 */
public class LinkedSong {

    private SongNode head;
    private SongNode tail;
    private int size;


    /**
     * Constructor for linked song
     */
    public LinkedSong() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * Getter that returns the head
     * 
     * @return Returns the head of the tail
     */
    public SongNode getHead() {
        return head;
    }


    /**
     * Getter that gets the tail of the list
     * 
     * @return tail Returns the tail of the list
     */
    public SongNode getTail() {
        return tail;
    }


    /**
     * Finds the entry at the requested position
     * 
     * @param index
     *            The position that is needed
     * @return temp the item at index's position
     */
    public SongNode getIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException(
                "LinkedSong getIndex method IOOB");
        }
        SongNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }


    /**
     * Adds an entry to the linked list
     * 
     * @param entry
     *            The SongNode that will be added
     */
    public void add(SongNode entry) {
        if (head == null) {
            head = entry;
            tail = head;
        }
        else {
            tail.setNext(entry);
            tail = tail.getNext();
        }
        size++;
    }


    /**
     * Size of LinkedSong nodes
     * 
     * @return size size of chain
     */
    public int size() {
        return size;
    }
}
