import java.util.ArrayList;
import java.util.Iterator;

public class HMIterator<E> implements Iterator<E>{
    private ArrayList<GenericQueue<E>> hashMap;
    private int index;

    //instantiates the first value in iterator
    public HMIterator(ArrayList<GenericQueue<E>> map){
        hashMap = map;
        this.index = 0;
    }

    // checks if the hashmap has next value
    @Override
    public  boolean hasNext(){
        return index < hashMap.size();
    }

    // returns the next value of hashmap


    @Override
    public  E next(){
        if(hasNext()){
            E data = hashMap.get(index).getHead().value;
            index++;
            return data;
        }
        return null;
    }


}