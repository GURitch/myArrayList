
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
    public void setUp() {
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
    public void testAddToIndex() {
        String s1 = "Element1";
        String s2 = "Element2";
        String s3 = "Element3";
        list.add(s1);
        list.add(s2);
        assertTrue(list.add(1, s3));
        assertEquals(list.get(1), s3);
        assertEquals(list.size(), 3);
    }

    @Test
    public void testSet() {
        String s1 = "Element1";
        String s2 = "Element2";
        String s3 = "Element3";
        list.add(s1);
        list.add(s2);
        assertTrue(list.set(1, s3));
        assertEquals(list.get(1), s3);
        assertEquals(list.size(), 2);
    }

    @Test
    public void testContains() {
        String s = "Element";
        list.add(s);
        assertTrue(list.contains(s));
    }

    @Test
    public void testGet() {
        String s = "Element";
        list.add(s);
        assertEquals(list.get(0), s);
    }

    @Test
    public void testDelete() {
        String s1 = "Element1";
        String s2 = "Element2";
        list.add(s1);
        list.add(s2);
        assertEquals(list.delete(1), s2);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), s1);
    }

    @Test
    public void testDeleteToValue() {
        String s1 = "Element1";
        String s2 = "Element2";
        list.add(s1);
        list.add(s2);
        assertEquals(list.delete(s2), s2);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), s1);
    }

    @Test
    public void testClear() {
        String s1 = "Element1";
        String s2 = "Element2";
        list.add(s1);
        list.add(s2);
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testSize() {
        String s1 = "Element1";
        String s2 = "Element2";
        list.add(s1);
        list.add(s2);
        assertEquals(list.size(), 2);
    }
}