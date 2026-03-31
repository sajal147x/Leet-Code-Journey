package com.leetcode.leetcode.StringEqualSwap.dynamicLength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public boolean checkStrings(String s1, String s2) {
       List<Character> evenIndexNums1 = new ArrayList<>();
       List<Character> oddIndexNums1 = new ArrayList<>();
       List<Character> evenIndexNums2 = new ArrayList<>();
       List<Character> oddIndexNums2 = new ArrayList<>();
       

       for (int i = 0; i < s1.length(); i ++){
        if (i%2 == 0){
            evenIndexNums1.add(s1.charAt(i));
            evenIndexNums2.add(s2.charAt(i));
        }
        else{
            oddIndexNums1.add(s1.charAt(i));
            oddIndexNums2.add(s2.charAt(i));
        }
       }
       Collections.sort(evenIndexNums1);
       Collections.sort(evenIndexNums2);
       Collections.sort(oddIndexNums1);
       Collections.sort(oddIndexNums2);

       if (evenIndexNums1.equals(evenIndexNums2) && oddIndexNums1.equals(oddIndexNums2)){
        return true;
       }

        return false;
    }  
}