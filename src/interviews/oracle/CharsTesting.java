package interviews.oracle;

import java.util.Stack;

public class CharsTesting {
    // () {} []

    public static void main(String[] args) {
        String string = "{{]]{]])";
        boolean isValidString = isValid(string);
        System.out.println("Valid String :: " + isValidString);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char newChar : chars) {
            if (!stack.empty()) {
                char existingChar = stack.peek();
                if (
                        (newChar == ')' && existingChar == '(') ||
                                (newChar == ']' && existingChar == '[') ||
                                (newChar == '}' && existingChar == '{')
                ) {
                    stack.pop();
                } else {
                    stack.push(newChar);
                }
            } else {
                stack.push(newChar);
            }
        }

        int size = stack.size();
        return size == 0;
    }
}


//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//Example 1:
//
//Input: prices = [7, 1, 5, 3, 6, 4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
//Constraints:
//
//1 <= prices.length <= 105
//0 <= prices[i] <= 104
//
//7, 1
//7, 5
//7, 3
//7, 6
//7, 4
//
//1, 5
//1, 3
//1, 6
//1, 4