package com.java.codes.GeeksCodes.trie;

public class WordBreak {
    private static class TrieNode {
        private int CHILD_SIZE = 26;
        TrieNode children[];
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[CHILD_SIZE];
            for (int i = 0; i < CHILD_SIZE; i++) {
                children[i] = null;
            }
            isEndOfWord = false;
        }
    }

    private static void insert(TrieNode root, String value) {
        TrieNode curNode = root;
        for (int i = 0; i < value.length(); i++) {
            int index = value.charAt(i) - 'a';
            if (curNode.children[index] == null)
                curNode.children[index] = new TrieNode();
            curNode = curNode.children[index];
        }
        curNode.isEndOfWord = true;
    }

    private static boolean search(TrieNode root, String value) {
        if (root == null) {
            return false;
        }
        TrieNode curNode = root;
        for (int i = 0; i < value.length(); i++) {
            int index = value.charAt(i) - 'a';
            if (curNode.children[index] == null)
                return false;
            curNode = curNode.children[index];
        }
        if (curNode != null && curNode.isEndOfWord) {
            System.out.println(value);
            return true;
        }
        return false;
    }

    private static boolean wordBreak(TrieNode root, String value) {
        if (root == null) return false;
        int size = value.length();
        if (size == 0) return true;
        for (int i = 1; i <= size; i++) {
            if (search(root, value.substring(0, i))
                    && wordBreak(root, value.substring(i, size)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String dictionary[] = {"mobile", "samsung",
                "sam", "sung", "ma",
                "mango", "icecream",
                "and", "go", "i", "like",
                "ice", "cream"};
        TrieNode root = new TrieNode();

        for (int i = 0; i < dictionary.length; i++)
            insert(root, dictionary[i]);
        String value = "ilikesamsung";
        System.out.print(wordBreak(root, value));
        System.out.println(value);
       /* System.out.print(wordBreak(root, "iiiiiiii"));
        System.out.print(wordBreak(root, ""));
        System.out.print(wordBreak(root, "ilikelikeimangoiii"));
        System.out.print(wordBreak(root, "samsungandmango"));
        System.out.print(wordBreak(root, "samsungandmangok"));*/
    }
}
