package com.utility;

import java.util.Objects;
import java.util.Stack;

/**
 * public trimString(String input){}
 * Given a string, remove adjacent duplicate characters from the string. The output string should not have any adjacent duplicates. See the following examples.
 * Input: azxxzy
 * Output: ay
 * First “azxxzy” is reduced to “azzy”.
 * The string “azzy” contains duplicates,
 * so it is further reduced to “ay”.
 * Azxxxzbbzy
 * Azzbbzy
 * Abbzy
 * Azy
 *
 * Public String trimString(String input,int left,int right){
 * 	//code goes here
 * }
 */
public class SampleCode {
    public static String compress(){
        try{
            throw new RuntimeException();
        } catch (RuntimeException e){
            return "yyyyy";
        } finally {
            return "pppp";
        }
    }
    public static void main(String[] args) {
        System.out.println(compress());
    }
}
