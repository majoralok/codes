package com.java.codes.GeeksCodes.tree;

import java.util.Stack;

public class BinarySearchTreeCheck {
    public Boolean checkBSTRepresentPreorderTraversal(int pre[]) {
        int n = pre.length, i, root = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (i = 0; i < n; i++) {
            if (pre[i] < root) {
                return false;
            }
            while (!st.empty() && st.peek() < pre[i]) {
                root = st.pop();
            }
            st.push(pre[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pre1 = new int[]{40, 30, 35, 20, 80, 100};
        BinarySearchTreeCheck binarySearchTreeCheck = new BinarySearchTreeCheck();
        System.out.println(binarySearchTreeCheck.checkBSTRepresentPreorderTraversal(pre1));
    }
}
