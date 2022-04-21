package com.java.codes.GeeksCodes.trie;

import java.util.LinkedList;
import java.util.List;

public class Suffix_tree {
    private final static int MAX_CHAR = 256;
    SuffixTrieNode root = new SuffixTrieNode();

    public Suffix_tree(String txt) {
        for (int i = 0; i < txt.length(); i++)
            root.insertSuffix(txt.substring(i), i);
    }

    private class SuffixTrieNode {
        SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
        List<Integer> indexes;

        public SuffixTrieNode() {
            indexes = new LinkedList<>();
            for (int i = 0; i < MAX_CHAR; i++)
                children[i] = null;
        }

        private void insertSuffix(String s, int index) {
            indexes.add(index);
            if (s.length() > 0) {
                char cIndex = s.charAt(0);
                if (children[cIndex] == null)
                    children[cIndex] = new SuffixTrieNode();
                children[cIndex].insertSuffix(s.substring(1), index + 1);
            }
        }

        private List<Integer> search(String s) {
            if (s.length() == 0)
                return indexes;
            if (children[s.charAt(0)] != null)
                return (children[s.charAt(0)]).search(s.substring(1));
            return null;
        }
    }

    private void search_tree(String pat) {
        List<Integer> result = root.search(pat);
        if (result == null)
            System.out.println("Pattern not found");
        else {
            int patLen = pat.length();
            for (Integer i : result)
                System.out.println("Pattern found at position " + (i - patLen));
        }
    }

    public static void main(String args[]) {
        String txt = "geeksforgeek";
        Suffix_tree S = new Suffix_tree(txt);

        System.out.println("Search for 'ee'");
        S.search_tree("ee");

        System.out.println("\nSearch for 'geek'");
        S.search_tree("geek");

        System.out.println("\nSearch for 'quiz'");
        S.search_tree("quiz");

        System.out.println("\nSearch for 'forgeeks'");
        S.search_tree("forgeeks");
    }
}
