package com.java.codes.GeeksCodes.meeting;

//maximum end time can be 100001
public class MinPlatformRequired {
    private int size = 100001;

    private int calculateMinPlatform(int platform[][]) {
        int maxPlat;
        int pre[] = new int[size];
        for (int i = 0; i < platform.length; i++) {
            pre[platform[i][0]] += 1;
            pre[platform[i][1] + 1] -= 1;
        }
        maxPlat = pre[0];
        for (int i = 0; i < 21; i++) {
            System.out.print(pre[i]+" ");
        }
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i] + pre[i-1];
            maxPlat = Math.max(pre[i],maxPlat);
        }
        System.out.println();
        for (int i = 0; i < 21; i++) {
            System.out.print(pre[i]+" ");
        }
        System.out.println();
        return maxPlat;
    }

    public static void main(String[] args) {
        int platform[][] = {
                {0, 5},
                {1, 2},
                {1, 10}
        };
        System.out.println(new MinPlatformRequired().calculateMinPlatform(platform));
    }
}
