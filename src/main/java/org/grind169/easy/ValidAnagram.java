package org.grind169.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * \uD83D (high surrogate)
 * \uDE00 (low surrogate)
 * Length: 7
 * charAt(0): S
 * charAt(1): m
 * charAt(2): i
 * charAt(3): l
 * charAt(4): e
 * charAt(5): ? (prints half of emoji)
 * charAt(6): ? (prints the other half)
 */

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        s.codePoints().forEach(cp -> {
            map.put(cp, map.getOrDefault(cp, 0) + 1);
        });

        IntStream text = t.codePoints();

        System.out.println(text);

        for (int cp : t.codePoints().toArray()) {
            map.put(cp, map.getOrDefault(cp, 0) - 1);
            if (map.get(cp) < 0) {
               return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String smileEmoji = "A\uD83D\uDE00\uD83D\uDE00";
        Set<Character> set = new HashSet<>();

        for(int i=0; i<smileEmoji.length(); i++) {
            if(set.contains(smileEmoji.charAt(i))) {
                System.out.println("Does exists");
                break;
            }
            set.contains(smileEmoji.charAt(i));
            System.out.println(smileEmoji.charAt(i));
        }
        System.out.println("---Using Code Points---");
        /*
         * Converts the specified character (Unicode code point) to its
         * UTF-16 representation stored in a {@code char} array. If
         * the specified code point is a BMP (Basic Multilingual Plane or
         * Plane 0) value, the resulting {@code char} array has
         * the same value as {@code codePoint}. If the specified code
         * point is a supplementary code point, the resulting
         * {@code char} array has the corresponding surrogate pair.
         */
        smileEmoji.codePoints().forEach(cp -> {
            char[] actualChar = Character.toChars(cp);
            System.out.println(actualChar);
        });

        boolean isItAnagram = isAnagram("anagram😀", "😀nagaram");

        System.out.println(isItAnagram);

    }
}
