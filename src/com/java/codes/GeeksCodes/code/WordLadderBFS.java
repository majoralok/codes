package com.java.codes.GeeksCodes.code;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs
 * Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
 * start = “TOON”
 * target = “PLEA”
 * Output: 7
 * TOON -> POON –> POIN –> POIE –> PLIE –> PLEE –> PLEA
 */
public class WordLadderBFS {
    private static int ladderLength(List<String> wordList, String start, String target) {
        int level = 0;
        if (!wordList.contains(target)) return level;
        Map<String, Map<Integer, List<String>>> adjVisitedLevelMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) { level++;

            int size = que.size();
            for (int i = 0; i < size; i++) {
                String word = que.poll();
                Map<Integer, List<String>> levelMap = new HashMap<>();
                levelMap.put(level, new ArrayList<>());

                char[] wordArr = word.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char originalChar = wordArr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordArr[j] = ch;
                        String newWord = String.valueOf(wordArr);
                        if (target.equals(newWord))
                            return level + 1;
                        if (ch == originalChar || !wordSet.contains(newWord)) continue;
                        que.add(newWord);
                        levelMap.get(level).add(newWord);
                        wordSet.remove(newWord);
                    }
                    wordArr[j] = originalChar;
                    adjVisitedLevelMap.put(word, levelMap);
                }
            }
        }
        return level;
    }

    public static void main(String args[]) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String start = "hit";
        String target = "cog";
        System.out.println(ladderLength(wordList, start, target));
    }
}
