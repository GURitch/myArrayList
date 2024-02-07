import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<T> {
    private Object[] array;
    private final int startCapacity = 5;
    private int size;

    public MyArrayList() {
        array = new Object[startCapacity];
    }

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            array = new Object[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public MyArrayList(Collection collections) {
        array = collections.toArray();
        size = array.length;
    }

    public boolean add(T element) {
        capacityCheck();
        array[size++] = element;
        return true;
    }

    public boolean set(int index, T element) {
        if (indexCheck(index)) {
            array[index] = element;
        }
        return true;
    }

    public boolean add(int index, T element) {
        if (indexCheck(index)) {
            capacityCheck();
            System.arraycopy(array, index, array, index + 1, size - 1);
            array[index] = element;
            size++;
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (indexCheck(index)) {
            return (T) array[index];
        }
        return null;
    }

    public T delete(int index) {
        if (size > 0 && indexCheck(index)) {
            T delElement = (T) array[index];
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
            size--;
            return delElement;
        }
        return null;
    }

    public T delete(T element) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(element)) {
                    System.arraycopy(array, i + 1, array, i, size - 1 - i);
                    size--;
                    return element;
                }
            }
        }
        return null;
    }

    public void clear(){
        array = new Object[startCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private boolean indexCheck(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return true;
    }

    private void capacityCheck() {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(array[i]);
            if (i < size - 1) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
