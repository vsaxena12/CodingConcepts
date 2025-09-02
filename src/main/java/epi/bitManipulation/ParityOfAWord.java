package epi.bitManipulation;

/**
 * Computing the parity of a word means determining whether the number of 1s in its binary representation is even or odd.
 * Used in error detection (e.g., network transmission, memory) and Helps detect single-bit errors
 * Parity = 0 → even number of 1s
 * Parity = 1 → odd number of 1s
 */
public class ParityOfAWord {
    public static int computeParity(int x) {
        // This is brute force algo iteratively tests each bit.  Code takes O(N) time complexity
        // It takes 2^32 entries to check all possible bits
        int parity = 0;
        int counter = 0;
        while (x != 0) {
            parity ^= (x & 1); // XOR each bit
            x >>>= 1;
            counter++;
        }
        System.out.println("Counter: "+counter);
        return parity; // 0 = even, 1 = odd. This takes O(n) time for an n-bit word — so for 32-bit words, that’s up to 32 iterations.
    }

    public static int computeParityImproved(int x) {
        // This is brute force algo iteratively tests each bit.  Code takes O(N) time complexity
        // It takes 2^32 entries to check all possible bits
        int counter = 0;
        int result = 0;
        while (x != 0) {
            result = result ^ 1; // XOR here is used for counting
            x = x & (x - 1); // Skip to next parity bit of 1
            counter++;
        }
        System.out.println("Counter: "+counter);
        return result; // 0 = even, 1 = odd. This takes O(n) time for an n-bit word — so for 32-bit words, that’s up to 32 iterations.
    }

    public static int computeParityO_1_(int x) {
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return x & 1;
    }

    public static void main(String[] args) {
        System.out.println("Parity: " + computeParity(0b10110110)); // Output: 1
        System.out.println("Parity: " + computeParityImproved(0b10110110));
        System.out.println("Parity: " + computeParityO_1_(0b10110110));
    }
}
