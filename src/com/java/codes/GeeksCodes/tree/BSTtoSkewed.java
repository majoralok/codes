package com.java.codes.GeeksCodes;
//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
public class BSTtoSkewed {
    static Node root = null ;
    static Node headNode = null;
    static Node prevNode = null;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        traverseRightSkewed(root.right);
    }

    public static void flatterBSTtoSkewed(Node node, boolean order) {
        if(node == null) return;
        if (order) {
            flatterBSTtoSkewed(node.left, order);
        } else {
            flatterBSTtoSkewed(node.right, order);
        }
        Node left = node.left;
        Node right = node.right;
        if(headNode == null){
            headNode = node;
            node.left = null;
            prevNode = node;
        } else {
            prevNode.right = node;
            node.left = null;
            prevNode = node;
        }
        if (order) {
            flatterBSTtoSkewed(right, order);
        } else {
            flatterBSTtoSkewed(left, order);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        flatterBSTtoSkewed(root, true);
        traverseRightSkewed(headNode);
    }
}
