package com.java.codes.GeeksCodes.rainwater;

import java.util.Stack;

public class LargestHistogram {
    private static int maxAreaHistogram(int histogram[]) {
        int max_area = 0, area, top;
        int i = 0, n = histogram.length;
        Stack<Integer> stack = new Stack<>();
        while (i < n) {
            if (stack.empty() || histogram[i] >= histogram[stack.peek()]) {
                stack.push(i++);
            } else {
                top = stack.pop();
                area = histogram[top]*(stack.empty()?i:i-stack.peek()-1);
                if (max_area < area)
                    max_area = area;
            }
        }
        while (!stack.empty()) {
            top = stack.pop();
            area = histogram[top] * (stack.empty() ? i : i - stack.peek() - 1);
            if (max_area < area)
                max_area = area;
        }
        return max_area;
    }

    public static void main(String[] args) {
        int histogram[] = {5, 4, 5};
        System.out.println(maxAreaHistogram(histogram));
    }
}
