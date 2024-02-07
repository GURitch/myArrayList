import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println(list);
        list.add(531);
        list.add(5435);
        list.add(454);
        System.out.println(list);
        list.add(2,999);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.delete(2) + " удален");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.delete((Integer) 5435) + " удален");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        MyArrayList<Person> personList = new MyArrayList<>();
        personList.add(new Person("Bob", 20));
        personList.add(new Person("John", 35));
        System.out.println(personList);
        Person otherPerson = new Person("Tom", 20);
        System.out.println(personList.contains(otherPerson));
        Person otherBob = new Person("Bob", 20);
        System.out.println(personList.contains(otherBob));
        Person oldBob = new Person("Bob", 60);
        System.out.println(personList.contains(oldBob));
        if (personList.get(1).getClass() == otherBob.getClass()) {
            System.out.println("Class equals");
        }
        System.out.println();

        Set<String> stringSet = new HashSet<>(List.of("первый", "второй", "третий"));
        MyArrayList<String> myArrayListFromSet = new MyArrayList<>(stringSet);
        System.out.println(myArrayListFromSet);
        myArrayListFromSet.clear();
        System.out.println(myArrayListFromSet);
    }
}
