package mpvisual;

public class LinkedSong {

    private SongNode head;
    private SongNode tail;
    private int size;


    public LinkedSong() {
        head = null;
        tail = null;
        size = 0;
    }


    public SongNode getHead() {
        return head;
    }


    public SongNode getTail() {
        return tail;
    }


    public SongNode getIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("LinkedSong getI method IOOB");
        }
        SongNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }


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


    public void set(SongNode entry, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("LinkedSong set method IOOB");
        }
        else if (index == 0) {
            entry.setNext(head.getNext());
            head = entry;
        }
        else {
            SongNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            entry.setNext(temp.getNext().getNext());
            temp.setNext(entry);
        }
    }
}
