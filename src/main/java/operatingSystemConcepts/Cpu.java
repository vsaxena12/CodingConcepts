package operatingSystemConcepts;

public class Cpu {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Cpu <string>");
            System.exit(1);
        }

        String str = args[0];

        while (true) {
            System.out.println(str);
            spin(1);  // spin for 1 second
        }
    }

    // Returns current time in seconds
    public static double getTime() {
        return System.nanoTime() / 1e9;
    }

    // Busy wait for 'howlong' seconds
    public static void spin(int howlong) {
        double start = getTime();
        while ((getTime() - start) < howlong) {
            // busy wait
        }
    }
}