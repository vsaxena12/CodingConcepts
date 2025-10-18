package collections.comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Students {
    private String name;
    private int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Comparators {
    public static void main(String[] args) {
        List<Students> list = new CopyOnWriteArrayList<>();
        list.add(new Students("Varun", 32));
        list.add(new Students("Brittany", 33));
        list.add(new Students("Ash", 34));
        list.add(new Students("John", 32));

        list.sort((a, b) -> a.getAge() - b.getAge());

        for(Students students: list) {
            System.out.println(students.getName()+" : "+students.getAge());
            if(students.getAge() == 32) {
                list.add(new Students("Mihir",29));
            }
        }
        System.out.println("------------------------------------------------\n");
        Comparator<Students> comparator = Comparator.comparing(Students::getName).thenComparing(Students::getAge);
        list.sort(comparator);
        for(Students students: list) {
            System.out.println(students.getName()+" : "+students.getAge());
        }

    }
}
