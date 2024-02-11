
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Класс для тестирования MyArrayList.
 */
public class MyArrayListTest {
    private MyArrayList<String> list;
    @Before
    public void setUp(){
        list = new MyArrayList<>();
    }

    @Test
    public void testAdd() {
        String s = "Element";
        assertTrue(list.add(s));
        assertEquals(1, list.size());
        assertEquals(s, list.get(0));
    }

    @Test
    public void testTestAdd() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void testContains() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testTestDelete() {
    }

    @Test
    public void testClear() {
    }

    @Test
    public void testSize() {
    }
}