package com.java.codes.GeeksCodes.MinSequence;

import java.util.Stack;

public class MinSequenceIandD {
    private void printSequenceIandD(String seq, int n) {
        Stack<Integer> st = new Stack<>();
        String result = "";
        for(int i= 0;i<=n;i++) {
            st.push(i+1);
            if(i == n || seq.charAt(i) == 'I') {
                while (!st.empty())
                    result += String.valueOf(st.pop()) + " ";
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        MinSequenceIandD minSequenceIandD = new MinSequenceIandD();
        String seq = "IDDI";
        minSequenceIandD.printSequenceIandD(seq, seq.length());
    }
}
