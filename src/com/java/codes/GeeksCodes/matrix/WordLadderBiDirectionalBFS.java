package com.java.codes.GeeksCodes.matrix;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs
 * <p>
 * Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
 * start = “TOON”
 * target = “PLEA”
 * Output: 7
 * TOON -> POON –> POIN –> POIE –> PLIE –> PLEE –> PLEA
 */
public class WordLadderBiDirectionalBFS {
    public static class node {
        String word;
        int len;

        public node(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    public static boolean isAdj(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        if (count == 1)
            return true;
        return false;
    }

    // Function to return the length of the shortest chain from 'beginWord' to 'endWord'
    public static int ladderLength(String beginWord, String endWord, ArrayList<String> wordList) {
    /* q1 is used to traverse the graph from beginWord and q2 is used to traverse the graph from endWord.
        vis1 and vis2 are used to keep track of the visited states from respective directions */
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();
        HashMap<String, Integer> vis1 = new HashMap<>();
        HashMap<String, Integer> vis2 = new HashMap<>();

        node start = new node(beginWord, 1);
        node end = new node(endWord, 1);

        vis1.put(beginWord, 1);
        q1.add(start);
        vis2.put(endWord, 1);
        q2.add(end);

        while (q1.size() > 0 && q2.size() > 0) {
            node curr1 = q1.poll();
            node curr2 = q2.poll();
            // Check all the neighbors of curr1
            for (String currWord : wordSet) {
                // If any one of them is adjacent to curr1 and is not present in vis1 then push it in the queue
                if (!vis1.containsKey(currWord) && isAdj(curr1.word, currWord)) {
                    wordSet.remove(currWord);
                    node temp = new node(currWord, curr1.len + 1);
                    // If temp is the destination node then return the answer
                    if (temp.word.equals(endWord)) {
                        return temp.len;
                    }
                    // If temp is present in vis2 i.e. distance from temp and the destination is already calculated
                    if (vis2.containsKey(temp.word)) {
                        return temp.len + vis2.get(temp.word) - 1;
                    }
                    q1.offer(temp);
                    vis1.put(currWord, curr1.len + 1);
                }
            }
            // Check all the neighbors of curr2
            for (String currWord : wordSet) {
                // If any one of them is adjacent to curr2 and is not present in vis1 then push it in the queue.
                if (!vis2.containsKey(currWord) && isAdj(curr2.word, currWord)) {
                    wordSet.remove(currWord);
                    node temp = new node(currWord, curr2.len + 1);
                    // If temp is the destination node then return the answer
                    if (temp.word.equals(beginWord)) {
                        return temp.len;
                    }
                    // If temp is present in vis1 i.e. distance from temp and the source is already calculated
                    if (vis1.containsKey(temp.word)) {
                        return temp.len + vis1.get(temp.word) - 1;
                    }
                    q2.add(temp);
                    vis2.put(currWord, curr2.len + 1);
                }
            }
        }
        return 0;
    }
    // Driver code
    public static void main(String args[]) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("poon");
        wordList.add("plee");
        wordList.add("same");
        wordList.add("poie");
        wordList.add("plie");
        wordList.add("poin");
        wordList.add("plea");

        String start = "toon";
        String target = "plea";

        System.out.println(ladderLength(start, target, wordList));
    }
}
