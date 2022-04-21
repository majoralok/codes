package com.java.codes.GeeksCodes.tree;

import java.util.HashSet;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size
 * groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 */
public class TreeMapCardCount {
    private static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : hand) {
            treeMap.putIfAbsent(num, 0);
            treeMap.put(num, treeMap.get(num) + 1);
        }
        while (treeMap.size() > 0) {
            int num = treeMap.firstKey();
            for (int card = num; card < num + groupSize; card++) {
                if (!treeMap.containsKey(card)) return false;
                Integer value = treeMap.get(card);
                if (value == 1) {
                    treeMap.remove(card);
                } else{
                    treeMap.put(card, value -1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 4, 6, 2, 3, 4, 7, 8};
        int w = 3;
        System.out.println(isNStraightHand(hand, w));
    }
}
