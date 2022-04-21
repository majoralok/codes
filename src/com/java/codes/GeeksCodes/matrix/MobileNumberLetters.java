package com.java.codes.GeeksCodes.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class MobileNumberLetters {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.length() == 0) return result;
        String[] keypadLetters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tyv", "wxyz"};
        result.add("");
        for(int i=0;i<digits.length();++i){
            int index = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length() == i){
                String permutation = result.poll();
                for(char c : keypadLetters[index].toCharArray()){
                    result.add(permutation+c);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
