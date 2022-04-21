package com.java.codes.GeeksCodes.Parentheses;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/calculate-score-of-a-string-consisting-of-balanced-parentheses
 *
 * https://www.geeksforgeeks.org/score-of-parentheses-using-tree
 */
public class CountParenthesisScore {
    public static int scoreOfParentheses1(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
    public static int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(scoreOfParentheses(s));
        System.out.println(scoreOfParentheses1(s));
    }
}
