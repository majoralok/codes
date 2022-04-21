package com.java.codes.GeeksCodes.BTree;

import java.util.Objects;

/**
 * https://leetcode.com/problems/binary-tree-cameras
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can
 * monitor its parent, itself, and its immediate children.
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 */
public class CameraInBTree {
    int cameras = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int minCameraCoverUtil(TreeNode root) {
        if (Objects.isNull(root)) return 1;
        int left = minCameraCoverUtil(root.left);
        int right = minCameraCoverUtil(root.right);
        if (left == -1 || right == -1) {
            cameras++;
            return 0;
        }
        if (left == 0 || right == 0)
            return 1;
        return -1;
    }

    public int minCameraCover(TreeNode root) {
        if(minCameraCoverUtil(root) ==  -1)
            cameras++;
        return cameras;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        /*root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);*/
        CameraInBTree cameraInBTree = new CameraInBTree();
        cameraInBTree.minCameraCover(root);
        System.out.println(cameraInBTree.cameras);
    }
}
