package com.leetcode.leetcode.matrix.kSwaps;

import java.util.Arrays;

/**
 * @author sajalgupta
 */
public class Solution {

    public boolean areSimilar(int[][] mat, int k) {
        
        for(int i = 0; i <mat.length; i++){
            int[] currArr = mat[i];
            int[] postSwap = arrayAfterKSwaps(currArr, k, i%2==0 ? "left" : "right");
            if(!Arrays.equals(postSwap, currArr)){
                return false;
            }
        }
        
        return true;
    }

    public int[] arrayAfterKSwaps(int[] arr, int k, String direction) {
    int n = arr.length;
    int[] result = arr.clone(); // start with a copy

    for (int t = 0; t < k; t++) { // repeat k times
        if (direction.equals("left")) {
            int first = result[0];
            for (int i = 0; i < n - 1; i++) {
                result[i] = result[i + 1];
            }
            result[n - 1] = first;
        } else { // right
            int last = result[n - 1];
            for (int i = n - 1; i > 0; i--) {
                result[i] = result[i - 1];
            }
            result[0] = last;
        }
    }

    return result;
}
}
