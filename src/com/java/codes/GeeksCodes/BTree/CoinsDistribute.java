package com.java.codes.GeeksCodes.BTree;

import java.util.Objects;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins.
 * There are n coins in total throughout the whole tree.
 */
public class CoinsDistribute {
    int ans = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int dfs(TreeNode node) {
        if (Objects.isNull(node)) return 0;
        int left = dfs( node.left);
        int right = dfs(node.right);
        ans += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        CoinsDistribute coinsDistribute = new CoinsDistribute();
        int coins = coinsDistribute.distributeCoins(root);
        System.out.println(coins);
    }
}