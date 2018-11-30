/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * ArrayQueue is a circular queue that uses an array
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 *
 * @param <T>
 *            Generic type T
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * Constructor for an ArrayQueue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * Gets the array length (capacity)
     * 
     * @return Returns the array length
     */
    public int getLength() {
        return queue.length;
    }


    /**
     * Gets the current size (length of queue)
     * 
     * @return Returns the size
     */
    public int getSize() {
        return size;
    }


    /**
     * Determines if the queue is empty
     * 
     * @return Returns whether the size is 0 or not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Helper method for ensureCapacity
     * 
     * @return Returns if the queue is full
     */
    private boolean isFull() {
        return size + 1 == queue.length;
    }


    /**
     * Adds an entry to the queue
     * 
     * @param entry
     *            The entry to be added
     */
    @Override
    public void enqueue(T entry) {
        ensureCapacity();
        queue[enqueueIndex] = entry;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;
    }


    /**
     * Expands the capacity if there is not enough. Throws an exception if
     * expanded over the max.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] temp = (T[])new Object[size * 2 + 1];
            if (temp.length >= MAX_CAPACITY) {
                throw new IllegalStateException("Max Queue Capacity Exceeded");
            }
            int k = 0;
            for (int i = dequeueIndex; i != enqueueIndex; i = incrementIndex(
                i)) {
                temp[k] = queue[i];
                k++;
            }
            dequeueIndex = 0;
            enqueueIndex = k;
            queue = temp;
        }
    }


    /**
     * Removes an entry from the queue
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        T temp = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return temp;
    }


    /**
     * Gets the first object in the queue
     * 
     * @return Returns the first entry in the queue
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        return queue[dequeueIndex];
    }


    /**
     * Clears the array of entries
     */
    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * Helper method to make sure the index wraps correctly
     * 
     * @param index
     *            The index to be incremented
     * @return Returns one more than the index, account for the capacity
     */
    private int incrementIndex(int index) {
        return (index + 1) % queue.length;
    }


    /**
     * Converts the queue to an array
     * 
     * @return Returns the converted array
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        Object[] temp = new Object[size];
        int k = 0;
        for (int i = dequeueIndex; i != enqueueIndex; i = incrementIndex(i)) {
            temp[k] = queue[i];
            k++;
        }
        return temp;
    }


    /**
     * Converts the ArrayQueue to a string
     * 
     * @return Returns the converted string
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Object[] temp = toArray();
        for (int i = 0; i < temp.length; i++) {
            builder.append(temp[i].toString());
            if (i + 1 < temp.length) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }


    /**
     * Compares two ArrayQueue Objects to see if they are equal
     * 
     * @param obj
     *            The object to be compared to
     * @return Returns whether or not the values are the same
     */
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            if (size != other.getSize()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                T myElement = queue[(dequeueIndex + i) % queue.length];
                T otherElement = other.queue[(other.dequeueIndex + i)
                    % other.queue.length];
                if (!myElement.equals(otherElement)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
