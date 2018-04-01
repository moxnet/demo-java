package tutorials.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ListDemo {
    public static void main(String[] args) {
        List<Person> personList1 = new ArrayList<>();
        List<Person> personList2 = new ArrayList<>();
        List<Person> personList3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person p = new Person(i, "name-" + i);
            personList1.add(p);
            personList2.add(p);
            personList3.add(new Person(i, "name-" + i));

        }
        System.out.println("personList1.equals(personList2):" + personList1.equals(personList2));
        System.out.println("personList1.equals(personList3):" + personList1.equals(personList3));


        List<String> personName = personList1.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("personeNameList:" + personName);

        // 对子 List 的修改操作，会影响到大 List，比如 clear, shuffle
//        personList1.subList(0, 4).clear();


        Collections.shuffle(personName.subList(0,5));
        System.out.println("Shuffled:\npersoneNameList:" + personName);
        Collections.rotate(personList1,2);
        System.out.println(indexOf(personName, personName.get(5)));
        System.out.println(personName.subList(5, personName.size()));

    }


    // 使用ListIterator实现的查找算法
    public static <E> int indexOf(List<E> list, E e) {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
            if (e == null ? it.next() == null : e.equals(it.next())) {
                return it.previousIndex();
            }
        }
        // Element not found
        return -1;
    }
}
