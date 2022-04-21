package com.java.codes.GeeksCodes.tree;

/**
 * https://www.geeksforgeeks.org/sum-of-distances-of-all-nodes-from-a-given-node/
 */
public class AllNodeSumTree {
    private static int sum = 0;

    static class TreeNode {
        int data;
        TreeNode left, right;
    }

    static TreeNode newNode(int data) {
        TreeNode Node = new TreeNode();
        Node.data = data;
        Node.left = Node.right = null;
        return (Node);
    }

    static int sumofdepth(TreeNode root, int l) {
        return root == null ? 0 : l + sumofdepth(root.left, l + 1) + sumofdepth(root.right, l + 1);
    }

    static int Noofnodes(TreeNode root) {
        return root == null ? 0 : 1 + Noofnodes(root.left) + Noofnodes(root.right);
    }

    static void distance(TreeNode root, int target, int distancesum, int n) {
        if (root.data == target) {
            sum = distancesum;
            return;
        }
        if (root.left != null) {
            int nodes = Noofnodes(root.left);
            int tempsum = distancesum - nodes + (n - nodes);
            distance(root.left, target, tempsum, n);
        }
        if (root.right != null) {
            int nodes = Noofnodes(root.right);
            int tempsum = distancesum - nodes + (n - nodes);
            distance(root.right, target, tempsum, n);
        }
    }

    public static void main(String[] args) {
        TreeNode root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);

        int target = 1;
        int distanceroot = sumofdepth(root, 0);
        int totalnodes = Noofnodes(root);
        distance(root, target, distanceroot, totalnodes);
        System.out.println(sum);
    }
}
