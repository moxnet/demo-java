package tutorials.collection;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            personList.add(new Person(i, "name-" + i));
        }

        // stream

//        System.out.println("stream  START:" + new Date());
//        personList.stream().filter(e -> e.getId() >= 5).forEach( e -> e.func());
//        System.out.println("stream  END  :" + new Date());


        System.out.println("stream  START:" + new Date());
        personList.parallelStream().filter(e -> e.getId() >= 5).forEach(e -> e.func());
        System.out.println("stream  END  :" + new Date());

        // for-each
        for (Person p : personList) {
            System.out.println(p.getName());
        }

        // iterator
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        // DELET when loop, ERROR CODE
//        for (Person p : personList) {
//            if (5 < p.getId()) {
//                personList.remove(p);
//            }
//        }

        // right method to remove
        for (Iterator<Person> iter = personList.iterator(); iter.hasNext(); ) {
            if (5 < iter.next().getId()) {
                iter.remove();
            }
        }


        Collections.singletonList("ss");
    }

}
