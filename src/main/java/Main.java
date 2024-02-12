import java.util.*;

public class Main {
    public static <T> void main(String[] args) {
        // Создаем лист Integer
        MyArrayList<Integer> numbersList = new MyArrayList<>();
        System.out.println(numbersList);

        // Добавляем элементы в конец списка
        numbersList.add(531);
        numbersList.add(5435);
        numbersList.add(454);
        numbersList.add(1);
        numbersList.add(3);
        System.out.println(numbersList);

        // Добавляем элемент по индексу
        numbersList.add(2,999);
        System.out.println(numbersList);
        System.out.println(numbersList.size());

        // Удаляем элемент по индексу
        System.out.println(numbersList.delete(2) + " удален");
        System.out.println(numbersList);
        System.out.println(numbersList.size());

        // Удаляем элемент по объекту
        System.out.println(numbersList.delete((Integer) 5435) + " удален");
        System.out.println(numbersList);
        System.out.println(numbersList.size());

        // Перезаписываем объект по индексу
        numbersList.set(0, 4);
        numbersList.set(1, 2);
        System.out.println(numbersList);
        System.out.println(numbersList.size());
        System.out.println();

        // Создаем лист типа Person и добавляем объекты
        MyArrayList<Person> personList = new MyArrayList<>();
        personList.add(new Person("Bob", 20));
        personList.add(new Person("John", 35));
        System.out.println(personList);
        personList.get(1).setAge(40);
        System.out.println(personList);

        // Вызываем метод contains с различными объектами
        Person otherPerson = new Person("Tom", 20);
        System.out.println(personList.contains(otherPerson));
        Person bob = new Person("Bob", 20);
        System.out.println(personList.contains(bob));
        Person otherBob = new Person("Bob", 60);
        System.out.println(personList.contains(otherBob));

        // Создаем список из множества
        Set<String> stringSet = new HashSet<>(List.of("первый", "второй", "третий"));
        MyArrayList<String> myArrayListFromSet = new MyArrayList<>(stringSet);
        System.out.println(myArrayListFromSet);

        // Полностью очищаем список
        myArrayListFromSet.clear();
        System.out.println(myArrayListFromSet);

        // Сортируем список numbersList через интерфейс Comparable (у Integer по умолчанию по возрастанию)
        System.out.println(numbersList);
        numbersList.sort();
        System.out.println(numbersList);

        // Сортируем список numbersList через интерфейс Comparator (реализуем свой вариант по убыванию, меняем местами -1 и 1 из оригинального кода)
        numbersList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? 1 : ((o1 == o2) ? 0 : -1);
            }
        });
        System.out.println(numbersList);

        personList.sort();
    }
}
