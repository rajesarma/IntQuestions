package com.lakshmi.interviews.dell;

import java.util.Stack;

public class BalancedClass {

    public static void main(String[] args) {
//        String s = "{[ ] }";      // --> true
//        String s = "{{[}";        // --> false
//        String s = "[{()()]}";    // --> false
        String s = "{[()()]}";    // --> true
//        String s = "{{ } []";     // --> false
//        String s = "{[}]";          // --> false
        System.out.println("Is balanced :: " + validParanthesis(s.trim().replace(" ","")));
    }

    private static boolean validParanthesis(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();

        char newChar, lastChar;
        for (char c : sArray) {
            newChar = c;
            if (!stack.isEmpty()) {
                lastChar = stack.peek();
                if ((lastChar == '{' && newChar == '}')
                        || (lastChar == '[' && newChar == ']')
                        || (lastChar == '(' && newChar == ')')
                ) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
