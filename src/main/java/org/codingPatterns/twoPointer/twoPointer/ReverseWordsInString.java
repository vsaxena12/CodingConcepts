package org.codingPatterns.twoPointer.twoPointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        // // Step 1: Clean up spaces and convert to char array
        // char[] chars = cleanSpaces(s.toCharArray());
        // // Step 2: Reverse entire array
        // reverse(chars, 0, chars.length - 1);
        // // Step 3: Reverse each word
        // int start = 0;
        // for (int end = 0; end <= chars.length; end++) {
        //     if (end == chars.length || chars[end] == ' ') {
        //         reverse(chars, start, end - 1);
        //         start = end + 1;
        //     }
        // }
        //return new String(chars);

        List<String> list = Arrays.asList(s.split("\\s++"));

        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }

    // Reverse function
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    // Removes extra spaces and returns trimmed char array
    private char[] cleanSpaces(char[] s) {
        int n = s.length;
        int i = 0, j = 0;
        while (j < n) {

            // skip leading spaces
            while (j < n && s[j] == ' ')
                j++;

            // copy non-space characters
            while (j < n && s[j] != ' ')
                s[i++] = s[j++];

            // skip extra spaces
            while (j < n && s[j] == ' ')
                j++;

            // add a single space between words
            if (j < n)
                s[i++] = ' ';
        }
        // return a trimmed array
        return Arrays.copyOfRange(s, 0, i);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));

    }
}
