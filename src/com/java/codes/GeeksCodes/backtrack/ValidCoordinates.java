package com.java.codes.GeeksCodes.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Another variation of IP Address problem
 * <p>
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".
 * For example, "(1, 3)" becomes s = "(13)" and "(2, 0.5)" becomes s = "(205)".
 * Return a list of strings representing all possibilities for what our original coordinates could have been.
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00",
 * "1.0", "001", "00.01", or any other number that can be represented with fewer digits.
 * <p>
 * https://leetcode.com/problems/ambiguous-coordinates
 */
public class ValidCoordinates {
    List<String> ans;

    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            helper(s.substring(0, i), s.substring(i));
        }
        return ans;
    }

    public void helper(String x, String y) {
        List<String> front = putDot(x);
        List<String> temp = putDot(y);
        List<String> rear = new ArrayList<>();
        for (String t : temp) {
            if (isValid(t)) rear.add(t);
        }
        for (String f : front) {
            if (isValid(f)) {
                for (String r : rear) {
                    ans.add("\"(" + f + "," + r + ")\"");
                }
            }
        }
    }

    public List<String> putDot(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);
        for (int i = 1; i < s.length(); i++) {
            result.add(s.substring(0, i) + "." + s.substring(i));
        }
        return result;
    }

    public boolean isValid(String s) {
        if (s.contains(".")) {
            String part[] = s.split("[.]");
            if (!part[0].equals("0") && part[0].startsWith("0")) return false;
            if (part[1].endsWith("0")) return false;
            return true;
        }
        if (s.equals("0")) return true;
        return !s.startsWith("0");
    }

    public static void main(String[] args) {
        String str = "(0123)";
        ValidCoordinates coordinates = new ValidCoordinates();
        System.out.println(coordinates.ambiguousCoordinates(str));
    }
}
