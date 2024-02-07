import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Класс MyArrayList представляет собой простую реализацию динамического массива.
 * Он обеспечивает основные операции добавления, удаления, получения элементов,
 * а также проверку наличия элемента в массиве и очистку массива.
 *
 * @param <T> тип элементов, хранящихся в списке
 */
public class MyArrayList<T> {
    private Object[] array;
    private final int startCapacity = 5;
    private int size;

    /**
     * Конструктор без параметров создает массив с начальной емкостью по умолчанию.
     */
    public MyArrayList() {
        array = new Object[startCapacity];
    }

    /**
     * Конструктор создает массив с заданной начальной емкостью.
     *
     * @param capacity начальная емкость массива
     * @throws IllegalArgumentException если указана отрицательная емкость
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            array = new Object[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Конструктор создает массив из переданной коллекции.
     *
     * @param collections коллекция, из которой будут скопированы элементы
     */
    public MyArrayList(Collection collections) {
        array = collections.toArray();
        size = array.length;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     * @return true, если элемент успешно добавлен
     */
    public boolean add(T element) {
        capacityCheck();
        array[size++] = element;
        return true;
    }

    /**
     * Добавляет элемент в указанную позицию списка.
     *
     * @param index   индекс, по которому будет произведено добавление
     * @param element элемент для добавления
     * @return true, если элемент успешно добавлен
     */
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

    /**
     * Заменяет элемент по указанному индексу на указанный элемент.
     *
     * @param index   индекс, по которому будет произведена замена
     * @param element новый элемент
     * @return true, если замена прошла успешно
     */
    public boolean set(int index, T element) {
        if (indexCheck(index)) {
            array[index] = element;
        }
        return true;
    }

    /**
     * Проверяет, содержит ли список указанный элемент.
     *
     * @param element элемент для проверки
     * @return true, если список содержит указанный элемент
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */
    public T get(int index) {
        if (indexCheck(index)) {
            return (T) array[index];
        }
        return null;
    }

    /**
     * Удаляет элемент по указанному индексу и возвращает его.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    public T delete(int index) {
        if (size > 0 && indexCheck(index)) {
            T delElement = (T) array[index];
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
            size--;
            return delElement;
        }
        return null;
    }

    /**
     * Удаляет первое вхождение указанного элемента из списка.
     *
     * @param element элемент для удаления
     * @return удаленный элемент
     */
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

    /**
     * Очищает список.
     */
    public void clear(){
        array = new Object[startCapacity];
        size = 0;
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return текущий размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет корректность индекса.
     *
     * @param index индекс для проверки
     * @return true, если индекс корректен
     * @throws ArrayIndexOutOfBoundsException если индекс выходит за размер списка
     */
    private boolean indexCheck(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return true;
    }

    /**
     * Выполняет увеличение емкости списка при необходимости.
     */
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
