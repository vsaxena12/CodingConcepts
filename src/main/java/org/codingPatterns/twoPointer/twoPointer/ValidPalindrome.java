package org.codingPatterns.twoPointer.twoPointer;

public class ValidPalindrome {

    static boolean isPalindrome(String s) {
        //[a,b,c,b,a]
        // i-------j
        int left = 0; //i
        int right = s.length() - 1; //j

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void RUNVALIDPALINDROME() {
        String[] testCase = {
                "RACECAR",
                "ABBA",
                "TART"
        };
        for (int i = 0; i < testCase.length; i++) {
            System.out.println("Test Case # " + (i + 1));
            System.out.println(isPalindrome(testCase[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void main(String[] args) {
        ValidPalindrome.RUNVALIDPALINDROME();
        ThreeSum.RUNTHREESUM();
    }
}
