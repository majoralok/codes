package com.java.codes.GeeksCodes.rainwater;

public class TrapRainWater {

    public Integer maxWaterQuantity(int vessal[]){
        int left_max = 0, right_max = 0, result=0;
        int low = 0, high = vessal.length-1;
        while(low < high){
            if(vessal[low] < vessal[high]){
                if(vessal[low] < left_max){
                    result += left_max - vessal[low];
                } else {
                    left_max = vessal[low];
                }
                low += 1;
            } else {
                if(vessal[high] < right_max){
                    result += right_max - vessal[high];
                } else {
                    right_max = vessal[high];
                }
                high -= 1;
            }
        }
        return result;
    }
}
