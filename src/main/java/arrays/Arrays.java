package arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays {
      public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            list.add(45);
            list.add(55);
            list.add(65);
            list.add(75);
            list.add(85);

            for (int i : list) {
                  System.out.println(i);
            }
            boolean contains = list.contains(55);
            System.out.println(contains);
            list.remove(0);
            list.remove(Integer.valueOf(65));

            System.out.println(list);
      }
}
