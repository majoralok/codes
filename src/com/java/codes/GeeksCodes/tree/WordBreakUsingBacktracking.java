package com.java.codes.GeeksCodes.tree;
//https://www.geeksforgeeks.org/word-break-problem-using-backtracking/?ref=rp

import java.util.Arrays;
import java.util.List;

public class WordBreakUsingBacktracking {
    private static List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
            "man", "mango", "icecream", "and", "cat","cats","and","sand","dog",
            "go", "i", "love", "ice", "cream");

    private static void wordBreakUtil(String word, String ans) {
        int n = word.length();
        for (int i = 1; i <= n; i++) {
            String prefix = word.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == n) {
                    System.out.println(ans+prefix);
                    return;
                }
                wordBreakUtil(word.substring(i, n), ans + prefix + " ");
            }
        }
    }

    private static void wordBreak(String str) {
        String ans = "";
        wordBreakUtil(str, ans);
    }

    public static void main(String[] args) {
        String str1 = "iloveicecreamandmango";
        String str2 = "ilovesamsungmobile";
        String str3 = "catsanddog";
        System.out.println("First Word");
        wordBreak(str1);
        System.out.println("Second Word");
        wordBreak(str2);
        System.out.println("Third Word");
        wordBreak(str3);
    }
}
