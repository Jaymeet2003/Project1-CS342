import java.util.*;

public abstract class GenericList<T> implements  Iterable<T> {
    private Node<T> head;
    private int length;


    public class Node<T>{
        T data;
        int code;
        Node<T> next;
    }

    // Printing list of items
    public void print(){
        if(this.head == null){
            System.out.println("Empty List");
        }else{
            Node<T> currentNode = head;
            while(currentNode != null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

    // Adding items to list depending on data structure
    public abstract void add(T data);

    // Deleting nodes depending on data structure

    public abstract T delete();

    // Stores and returns value of ArrayList

    public ArrayList<T> dumpList(){
        if (this.head == null) {
            return null;
        }else{
            ArrayList<T> list = new ArrayList<>();
            Node<T> currentNode = head;
            while(currentNode != null){
                list.add(currentNode.data);
                currentNode = currentNode.next;
            }
            return list;
        }
    }

    // Returns value at specified index.

    public T get( int index){
        if (index < 0 || index >= length || this.head == null) {
            return null;
        }

        Node<T> currentNode = head;
        for(int i= 0; i < index; i++){
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    //The element at the provided position in the list will be replaced with the specified element,
    // and the element that was previously at the specified position will be returned.

    public T set(int index, T element){
        if (index < 0 || index > length || this.head == null) {
            return null;
        }
        Node<T> currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        T previousNode = get(index);
        currentNode.data = element;
        return previousNode;
    }

    // getter for length

    public int getLength(){
        return length;
    }

    // setter for length

    public void setLength(int length){
        this.length = length;
    }

    // getter for head node

    public Node<T> getHead(){
        return head;
    }

    // setter for head node

    public void setHead(Node<T> head){
        this.head = head;
    }


    //overriding iterator

    @Override
    public Iterator<T> iterator(){
            GLLIterator<T> iterator = new GLLIterator<T>(head);
            return iterator;
    }



    //returns the iterator in reverse order

    public Iterator<T> descendingIterator(){
        if (this.head == null) {
            return null;
        }

        return new ReverseGLLIterator<>(this.head);
    }
}