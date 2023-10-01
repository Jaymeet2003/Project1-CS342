import java.util.*;

public class GenericQueue<T> extends GenericList<T>{
    private Node<T> tail;

    // default constructor to initialize queue
    public GenericQueue(T data){

        Node<T> newNode = new Node<>();
        newNode.data = data;
        setHead(newNode);
        tail = getHead();
        setLength(1);
    }

    // implimenting add for queue
    @Override
    public void add(T data){
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if(getHead() == null){
            setHead(newNode);
            tail = getHead();
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength() + 1);
    }


    // implimenting delete for queue
    @Override
    public T delete(){
        T newNode;
        Node<T> currentNode = getHead();
        if (currentNode == null) {
            return null;
        }

        if(currentNode == tail){
            setHead(null);
            tail = null;
        }else{
            while(currentNode.next != tail){
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            tail = currentNode;
        }
        setLength(getLength() - 1);
        return tail.data;
    }

    // adds node at specified location
    public void add(T data, int code){
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.code = code;

        if(getHead() == null){
            setHead(newNode);
            tail = getHead();
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        setLength(getLength() + 1);
    }

    // adds node
    public void enqueue(T data){
        add(data);
    }

    // deletes node
    public T dequeue(){
        return delete();
    }
}