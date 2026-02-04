package com.leetcode.leetcode.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sajalgupta
 */


class Solution {

    // return indices of numbers that add up to the target, only one pair in list
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pairIdx.containsKey(target - num)) {
                return new int[] { i, pairIdx.get(target - num) };
            }
            pairIdx.put(num, i);
        }

        return new int[] {};        
    }
    
    
}