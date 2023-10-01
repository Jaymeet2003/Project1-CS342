import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HMTest {

    private MyHashMap<String> map;


    @BeforeEach
    public void initializeHashMap(){
        this.map = new MyHashMap<String>("l", "h");
        map.put("j", "k");
        map.put("g", "p");
        map.put("n", "m");
    }

    @Test
    public void testGet(){
        assertEquals("h", map.get("l"));
        assertEquals("k", map.get("j"));
        assertEquals("p", map.get("g"));
        assertEquals("m", map.get("n"));
    }

    @Test
    public void testContains(){
        assertTrue(map.contains("l"));
        assertTrue(map.contains("j"));
        assertTrue(map.contains("n"));
        assertFalse(map.contains("i"));
        assertFalse(map.contains("z"));
    }

    public void testSize(){
        assertEquals(4, map.size());
        map.put("s", "t");
        assertEquals(5, map.size());

    }
    @Test
    public void testIsEmpty(){
        assertFalse(map.isEmpty());
    }

    @Test
    public void testReplace() {
         map.replace("l", "o");
        assertEquals("o", map.get("l"));
        assertEquals("k", map.get("j"));
    }

   /* @Test
    public void testQueueIterator() {
        Iterator<String> iterator = map.iterator();

        //assertNotNull(iterator);

        assertEquals(map.get("l"), iterator.next());
    }*/

    @Test
    public void testIterator(){
        Iterator<String> it = map.iterator();
        ArrayList<String> list = new ArrayList<String>();
        while(it.hasNext()){
            list.add(it.next());
        }
        assertEquals(4, list.size());
        assertTrue(list.contains("h"));
        assertTrue(list.contains("k"));
        assertTrue(list.contains("p"));
        assertTrue(list.contains("m"));
    }
}