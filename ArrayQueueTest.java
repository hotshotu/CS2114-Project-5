/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * ArrayQueueTest tests every method in ArrayQueue
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class ArrayQueueTest extends TestCase {
    private ArrayQueue<Integer> aq1;


    /**
     * Sets up each test case
     */
    public void setUp() {
        aq1 = new ArrayQueue<Integer>();
        aq1.enqueue(0);
        aq1.enqueue(1);
        aq1.enqueue(2);
    }


    /**
     * Tests most of the common methods
     */
    public void testMainMethods() {
        assertEquals(11, aq1.getLength());
        assertEquals(3, aq1.getSize());
        assertEquals(0, (int)aq1.getFront());
        assertEquals("[0, 1, 2]", aq1.toString());
        assertFalse(aq1.isEmpty());
        aq1.clear();
        assertTrue(aq1.isEmpty());

        for (int i = 0; i < 11; i++) {
            aq1.enqueue(i);
        }
        assertEquals(21, aq1.getLength());
        aq1.dequeue();
        aq1.dequeue();
        for (int i = 11; i < 20; i++) {
            aq1.enqueue(i);
        }

        int[] temp = new int[18];
        for (int i = 2; i < 20; i++) {
            temp[i - 2] = i;
        }
        for (int i = 0; i < temp.length; i++) {
            assertEquals(temp[i], aq1.toArray()[i]);
        }

        ArrayQueue<Integer> aq5 = new ArrayQueue<Integer>();
        try {
            assertEquals(0, aq5.toArray().length);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof EmptyQueueException);
        }
        aq5.enqueue(1);
        aq5.enqueue(2);
        assertEquals(2, aq5.toArray().length);
        aq5.enqueue(3);
        aq5.enqueue(4);
        aq5.enqueue(5);
        aq5.enqueue(6);
        aq5.enqueue(7);
        aq5.enqueue(8);
        aq5.enqueue(9);
        aq5.dequeue();
        aq5.dequeue();
        aq5.dequeue();
        aq5.enqueue(2);
        aq5.enqueue(3);
        ArrayQueue<Integer> aq4 = new ArrayQueue<Integer>();
        try {
            aq4.getFront();
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof EmptyQueueException);
        }

        aq5.enqueue(4);
        aq5.enqueue(5);
        aq5.enqueue(6);
        assertEquals(21, aq5.getLength());

        ArrayQueue<Integer> aq6 = new ArrayQueue<Integer>();
        assertEquals("[]", aq6.toString());
    }


    /**
     * Tests fringe cases and longer methods
     */
    public void testOther() {
        ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>();
        for (int i = 0; i < 80; i++) {
            aq2.enqueue(i);
        }
        try {
            aq2.enqueue(81);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalStateException);
        }
        aq2.dequeue();
        aq2.dequeue();
        aq2.enqueue(6);

        ArrayQueue<Integer> aq3 = new ArrayQueue<Integer>();
        aq3.enqueue(-1);
        aq3.enqueue(0);
        aq3.enqueue(1);
        aq3.enqueue(2);
        aq3.dequeue();
        Object objaq = new Object();
        assertFalse(aq1.equals(objaq));
        assertFalse(aq1.equals(aq2));
        assertTrue(aq1.equals(aq3));
        aq3.enqueue(4);
        aq3.dequeue();
        assertFalse(aq1.equals(aq3));

        ArrayQueue<Integer> aq4 = new ArrayQueue<Integer>();
        try {
            aq4.dequeue();
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof EmptyQueueException);
        }

        ArrayQueue<Integer> aq5 = null;
        assertFalse(aq4.equals(aq5));
        try {
            aq4.getFront();
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof EmptyQueueException);
        }
    }
}
