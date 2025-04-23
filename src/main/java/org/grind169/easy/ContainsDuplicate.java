package org.grind169.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

      //This is using HashSet - T(O(n)) and S(O(n))
      public static boolean containsDuplicate_HashSet(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int i: nums) {
                  if(set.contains(i)) {
                        return true;
                  }
                  set.add(i);
            }
            return false;
      }

      public static boolean containsDuplicate_Sorting(int[] nums) {
            Arrays.sort(nums);
            for(int i=0; i<nums.length-1; i++) {
                  if(nums[i] == nums[i+1]) {
                        return true;
                  }
            }
            return false;
      }

      public static void main(String[] args) {
            boolean doesItContainsDuplicate = containsDuplicate_Sorting(new int[]{1,2,3,1});

            System.out.println("Does it contains duplicate: "+doesItContainsDuplicate);
      }      
}
