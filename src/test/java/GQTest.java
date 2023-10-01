import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class GQTest {

    private GenericQueue<Integer> queue1;
    private GenericQueue<Double> queue2;
    private GenericQueue<String> queue3;
    private final int[] intArray = {5, 9, 8, 10, 17};
    private final double[] doubleArray = {12.2, 14.5, 17.8, 19.5, 12.6};
    private final String[] stringArray = {"this", "one", "was", "amazing", "thing"};

    @BeforeEach
    public void initializingQueues() {
        this.queue1 = new GenericQueue<>(1);
        for (int i = 0; i < intArray.length; i++) {
            this.queue1.enqueue(intArray[i]);
        }

        this.queue2 = new GenericQueue<>(12.0);
        for (int i = 0; i < doubleArray.length; i++) {
            this.queue2.enqueue(doubleArray[i]);
        }

        this.queue3 = new GenericQueue<>("Hi!");
        for (int i = 0; i < stringArray.length; i++) {
            this.queue3.enqueue(stringArray[i]);
        }
    }


    @Test
    public void testQueueLengths() {
        assertEquals((intArray.length + 1), queue1.getLength(), "Length differs");
        assertEquals((doubleArray.length + 1), queue2.getLength(), "Length differs");
        assertEquals((stringArray.length + 1), queue3.getLength(), "Length differs");
    }

    @Test
    public void testQueueNull() {
        assertNotNull(queue1.toString(), "Queue must not be empty");
        assertNotNull(queue2.toString(), "Queue must not be empty");
        assertNotNull(queue3.toString(), "Queue must not be empty");
    }

    @Test
    public void testQueueEnqueue() {
        queue1.enqueue(45);
        queue2.enqueue(45.5);
        queue3.enqueue("Temp queue");
        assertEquals(7, queue1.getLength());
        assertEquals(7, queue2.getLength());
        assertEquals(7, queue3.getLength());
    }


    @Test
    public void testQueueDequeue() {
        assertEquals(10, queue1.dequeue());
        assertEquals(19.5, queue2.dequeue());
        assertEquals("amazing", queue3.dequeue());
    }

    @Test
    public void testQueueDequeue1() {
        queue1.dequeue();
        queue2.dequeue();
        queue3.dequeue();
        assertEquals(8, queue1.dequeue());
        assertEquals(17.8, queue2.dequeue());
        assertEquals("was", queue3.dequeue());
    }

    @Test
    public void testQueueSet() {
        queue1.set(2, 44);
        queue2.set(2, 47.8);
        queue3.set(2, "Temp queue");
        assertEquals(queue1.get(2), 44);
        assertEquals(47.8, queue2.get(2));
        assertEquals(queue3.get(2), "Temp queue");
    }

    @Test
    public void testQueueDumpList() {
        ArrayList<Integer> list1 = queue1.dumpList();
        ArrayList<Double> list2 = queue2.dumpList();
        ArrayList<String> list3 = queue3.dumpList();

        assertEquals(list1.size(), queue1.getLength());
        assertEquals(list2.size(), queue2.getLength());
        assertEquals(list3.size(), queue3.getLength());
    }

    @Test
    public void testQueueIterator() {
        Iterator<Integer> iterator1 = queue1.iterator();
        Iterator<Double> iterator2 = queue2.iterator();
        Iterator<String> iterator3 = queue3.iterator();

        assertNotNull(iterator1);
        assertNotNull(iterator2);
        assertNotNull(iterator3);

        assertEquals(queue1.get(0), iterator1.next());
        assertEquals(queue2.get(0), iterator2.next());
        assertEquals(queue3.get(0), iterator3.next());
    }

    @Test
    public void testQueueIteratorDescending() {
        Iterator<Integer> iterator1 = queue1.descendingIterator();
        Iterator<Double> iterator2 = queue2.descendingIterator();
        Iterator<String> iterator3 = queue3.descendingIterator();

        assertNotNull(iterator1);
        assertNotNull(iterator2);
        assertNotNull(iterator3);

        assertEquals(17, iterator1.next());
        assertEquals(12.6, iterator2.next());
        assertEquals("thing", iterator3.next());


    }
}