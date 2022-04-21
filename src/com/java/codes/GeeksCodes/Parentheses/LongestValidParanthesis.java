package com.java.codes.GeeksCodes.Parentheses;

import java.util.Stack;

public class LongestValidParanthesis {
    private static int printLongestParaLength(String str) {
        int result = 0;
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(')
                indexStack.push(i);
            else{
                if(!indexStack.isEmpty())
                    indexStack.pop();
                if(!indexStack.isEmpty())
                    result = Math.max(result, i-indexStack.peek());
                else
                    indexStack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "((()()()()(((())";
        System.out.println(printLongestParaLength(str));
    }
}
