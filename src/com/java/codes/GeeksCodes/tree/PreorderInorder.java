package com.java.codes.GeeksCodes.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal
 */
public class PreorderInorder {
    static Map<Integer, Integer> mapInorder = new HashMap<>();
    static Node root;
    static int preorderIndex = 0;

    static class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }

    static Node constructTreeUtil(int[] inorder, int[] preorder, int low, int high) {
        if (low > high) return null;
        int value = preorder[preorderIndex++];
        Node node = new Node(value);
        if (low == high) return node;
        int mid = mapInorder.get(value);
        node.left = constructTreeUtil(inorder, preorder, low, mid - 1);
        node.right = constructTreeUtil(inorder, preorder, mid + 1, high);
        return node;
    }

    static Node constructTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            mapInorder.put(inorder[i], i);
        }
        return constructTreeUtil(inorder, preorder, 0, len - 1);
    }

    static void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        printTree(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        int preorder[] = {5, 3, 2, 4, 8, 6, 9};
        int inorder[] = {2, 3, 4, 5, 6, 8, 9};
        root = constructTree(preorder, inorder);
        printTree(root);
    }
}
