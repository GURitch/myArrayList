
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

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

    @Test
    public void testSortComparator() {
        String a = "aaa", b = "bb", c = "c";
        list.add(b);
        list.add(c);
        list.add(a);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? 0 : -1;
            }
        });
        assertEquals(c, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(a, list.get(2));
    }

    @Test
    public void testSortComparable() {
        String a = "aaa", b = "bb", c = "c";
        list.add(b);
        list.add(c);
        list.add(a);
        list.sort();
        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
    }

    @Test
    public void testSortComparableException() {
        MyArrayList<Person> personMyArrayList = new MyArrayList<>();
        personMyArrayList.add(new Person("Bob", 30));
        personMyArrayList.add(new Person("John", 40));
        assertThrows(UnsupportedOperationException.class, personMyArrayList::sort);
    }
}