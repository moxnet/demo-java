package tutorials.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setAge(i * 10);
            p.setName("name-age-" + i * 10);
            p.setEmailAddress("email-" + i + "@codox.cn");
            p.setGender(i % 2 == 0 ? Person.Sex.MALE : Person.Sex.FEMALE);
            list.add(p);
        }

        // print male, and age > 25

        // method 1:
        printPersonOlderThan(list, 25);

        // method 2: with class implements CheckPerson
        printPerson(list, new PrintPersonOlterThan25());

        // method 3: with CheckPerson anonymouse method
        printPerson(list,  new CheckPerson() {
            @Override
            public boolean test(Person p) {
                if (p.getAge() > 25) {
                    return true;
                }
                return false;
            }
        });

        //method 4: lambda
        System.out.println("use lambda:");
        printPerson(list, (Person p) -> p.getAge() > 25);

        // method 5: lambda with predicate
        System.out.println("use lambda(predicate):");
        printPersonWithPredicate(list, (Person p) -> p.getAge() > 25);

        // method 6:
        System.out.println("use lambda(predicate & consumer):");
        printPerson(list, (Person p) -> p.getAge() > 25, (Person p) -> p.printPerson());

        // add Function(T,R)
        System.out.println("use lambda(predicate & function(T,R), consumer):");
        printPerson(list, p -> p.getAge() > 25, p -> p.getEmailAddress(), e -> System.out.println(e));

    }

    public static void printPersonOlderThan(List<Person> list, int age) {
        for (Person p : list) {
            if (p.getAge() > age) {
                p.printPerson();
            }
        }
    }

    public static void printPerson(List<Person> list, CheckPerson checker ) {
        for (Person p : list) {
            if (checker.test(p) ) {
                p.printPerson();
            }
        }
    }

    public static void printPersonWithPredicate(List<Person> list, Predicate<Person> c) {
        for (Person p : list) {
            if (c.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPerson(List<Person> list, Predicate<Person> p, Consumer<Person> c) {

        for (Person person : list) {
            if (p.test(person)) {
                c.accept(person);
            }
        }
    }
    public static void printPerson(List<Person> list, Predicate<Person> p, Function<Person, String> f, Consumer<String> c) {
        for (Person person : list) {
            if (p.test(person)) {
                String email = f.apply(person);
                c.accept(email);
            }
        }
    }

    public static class PrintPersonOlterThan25 implements CheckPerson {

        @Override
        public boolean test(Person p) {
            if (p.getAge() > 25) {
                return true;
            }
            return false;
        }
    }

}
