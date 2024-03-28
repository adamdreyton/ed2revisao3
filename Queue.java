import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    private class Node {
        private Item item;
        private Node next;
    }

    public Item dequeue() {
        Item item = null;
        if (isEmpty())
            throw new NoSuchElementException();
        else {
            item = first.item;
            first = first.next;
            if (isEmpty())
                last = null; // to avoid loitering, last = first;
            n--;
        }

        return item;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        Node newNode = new Node();
        newNode.item = item;
        last = newNode;

        if (isEmpty())
            first = last;
        else
            oldLast.next = newNode;

        n++;
    }

    public Item getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.item;
    }

    public Item getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Queue() {
        first = last = null;
        n = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }
}