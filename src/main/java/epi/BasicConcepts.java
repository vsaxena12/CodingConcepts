package epi;

public class BasicConcepts {
    public static void main(String[] args) {
        byte b = -1;
        System.out.println(b);
        int i = Byte.toUnsignedInt(b);
        System.out.println(i);

        int integer = -1;
        long unsignedInt = Integer.toUnsignedLong(integer);
        System.out.println(unsignedInt);
    }
}
