import java.util.Iterator;

public class ReverseGLLIterator<E> implements Iterator<E>{
    private GenericList<E>.Node<E> head;

  //instantiates new iterator in reverse order
    public ReverseGLLIterator(GenericList<E>.Node<E> head) {

        GenericList<E>.Node<E> previousNode = null;
        GenericList<E>.Node<E> currentNode = head;
        GenericList<E>.Node<E> nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.head = previousNode;

    }


    @Override
    public boolean hasNext() {

        return this.head != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            return null;
        }

        E nextNode = this.head.data;
        this.head = this.head.next;

        return nextNode;

    }
}

