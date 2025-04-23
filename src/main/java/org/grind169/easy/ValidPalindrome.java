package org.grind169.easy;

public class ValidPalindrome {

      public static boolean isPalindrome(String s) {
            // s = s.toLowerCase();
            // Strings are immutable and hence creates extra space - O(n)
            // Optimize the results: Use Character.toLowerCase(); 
            // s = s.toLowerCase()        O(n)        Eager work        Fast for small strings, wasteful for large ones
            // Character.toLowerCase()    O(1)        Lazy work         Better for early exit and big inputs

            int left = 0;
            int right = s.length()-1;    
            while(left<right) {
                    while(left<right && !(Character.isLetterOrDigit(s.charAt(left)))) {
                        left++;
                    }
                    while(left<right && !(Character.isLetterOrDigit(s.charAt(right)))) {
                        right--;
                    }
                    if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    left++;
                    right--;
            }
            return true;
      }

      public static void main(String[] args) {
            String s = "A man, a plan, a canal: Panam";
            boolean bool = isPalindrome(s);
            System.out.println("Is Valid Palindrome: "+bool);

      }
      
}
