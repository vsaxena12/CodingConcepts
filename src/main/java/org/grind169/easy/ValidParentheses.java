package org.grind169.easy;

import java.util.Stack;
/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && (stack.peek() == '(' && s.charAt(i) == ')' || 
            stack.peek() == '[' && s.charAt(i) == ']' ||
            stack.peek() == '{' && s.charAt(i) == '}')) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "([{}])";
        System.out.println(vp.isValid(s)); // Output: true
    }
}
