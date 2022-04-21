package com.java.codes.GeeksCodes.generic;

//Count smaller elements on right side
public class CountSmallerElements {
    private static class Node {
        int value;
        int countRightSmallerElements;
        Node left;
        Node right;

        public Node(int value, int countRightSmallerElements) {
            this.value = value;
            this.countRightSmallerElements = countRightSmallerElements;
            this.left = null;
            this.right = null;
        }
    }

    private static int getSmallerElementsOnRightSide(Node root, int value, int countSmaller) {
        if (root == null) {
            return countSmaller;
        }
        if (root.value < value) {
            if (root.right == null) {
                root.right = new Node(value, 0);
                return root.countRightSmallerElements+ countSmaller + 1;
            } else {
                return root.countRightSmallerElements + getSmallerElementsOnRightSide(root.right, value, 1 + countSmaller);
            }
        } else {
            root.countRightSmallerElements += 1;
            if (root.left == null) {
                root.left = new Node(value, 0);
                return countSmaller;
            } else {
                return getSmallerElementsOnRightSide(root.left, value, countSmaller);
            }
        }
    }

    public static void main(String[] args) {
        int data[] = {10, 9,8, 7 ,6};
        int size = data.length, i;
        int arr[] = new int[size];
        Node root = new Node(data[size - 1], 0);
        for (i = size - 2; i >= 0; i--) {
            arr[i] = getSmallerElementsOnRightSide(root, data[i], 0);
        }
        for (int v : arr) {
            System.out.print(v + "  ");
        }
    }
}
