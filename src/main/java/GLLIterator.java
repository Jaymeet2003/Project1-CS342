import java.util.Iterator;

public class GLLIterator<E> implements Iterator<E> {
    private GenericList<E>.Node<E> head;

    // constructor to initialize the head
    public GLLIterator(GenericList<E>.Node<E> head) {

        this.head = head;
    }

    // checks if the list has next value
    @Override
    public boolean hasNext() {

        return this.head != null;
    }

    // returns the next value of list
    @Override
    public E next() {
        if (!hasNext()) {
            return null;
        }

        GenericList<E>.Node<E> nextNode = this.head;
        this.head = this.head.next;

        return nextNode.data;

    }
}