package com.java.codes.GeeksCodes.slidingwindow;

/**
 * https://leetcode.com/problems/push-dominoes
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously
 * push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * Input: dominoes = ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 */
public class PushDominoesLeetcode {
    public String pushDominoes(String dominoe) {
        char[] dominoes = dominoe.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int n = dominoes.length;
        int[] forceValue = new int[n];
        int force = 0;
        for(int i=0;i<n;i++){
            if(dominoes[i] == 'R'){
                force = n;
            } else if(dominoes[i] == 'L'){
                force = 0;
            } else{
                force = Math.max(force-1, 0);
            }
            forceValue[i] += force;
        }
        force = 0;
        for(int i=n-1;i>=0;--i){
            if(dominoes[i] == 'L'){
                force = n;
            } else if(dominoes[i] == 'R'){
                force = 0;
            } else{
                force = Math.max(force-1, 0);
            }
            forceValue[i] -= force;
        }
        for(int f: forceValue){
            if(f>0) stringBuilder.append('R');
            else if(f<0) stringBuilder.append('L');
            else stringBuilder.append('.');
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String st = ".L.R..LR.";
        PushDominoesLeetcode pushDominoesLeetcode = new PushDominoesLeetcode();
        System.out.println(pushDominoesLeetcode.pushDominoes(st));
    }
}
