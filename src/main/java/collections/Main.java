package collections;

import org.postgresql.shaded.com.ongres.stringprep.StringPrep;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println(elementData.length);

        list.add(1);

        elementData = (Object[]) field.get(list);
        System.out.println(elementData.length);


    }
}
