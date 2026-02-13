package com.leetcode.leetcode.containerMostWater;

/**
 * Author: Sajal Gupta
 * Date: 2/13/26 5:26 PM
 */
class Solution {


    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (right > left){
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = currentHeight * width;
            maxArea = Math.max(area, maxArea);
            if (height[right] > height[left]){
                left += 1;
            }
            else if(height[left] > height[right]){
                right -= 1;
            }
            else{
                left+=1;
                right-=1;
            }
        }

        return maxArea;
    }
}