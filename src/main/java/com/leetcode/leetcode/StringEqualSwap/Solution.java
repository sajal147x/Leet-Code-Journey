package com.leetcode.leetcode.StringEqualSwap;

public class Solution {

    public boolean canBeEqual(String s1, String s2) {

        if (s1.equals(s2)){
            return true;
        }

        char[] tempCharArray = new char[4];

        //FIRST POSSIBLE WAY
        tempCharArray[0] = s1.charAt(2);
        tempCharArray[1] = s1.charAt(1);
        tempCharArray[2] = s1.charAt(0);
        tempCharArray[3] = s1.charAt(3);

        if (s2.equals(new String(tempCharArray))){
            return true;
        }

        //SECOND POSSIBLE WAY
        tempCharArray[0] = s1.charAt(2);
        tempCharArray[1] = s1.charAt(3);
        tempCharArray[2] = s1.charAt(0);
        tempCharArray[3] = s1.charAt(1);
        if (s2.equals(new String(tempCharArray))){
            return true;
        }

        //THIRD POSSIBLE WAY
        tempCharArray[0] = s1.charAt(0);
        tempCharArray[1] = s1.charAt(3);
        tempCharArray[2] = s1.charAt(2);
        tempCharArray[3] = s1.charAt(1);

        if (s2.equals(new String(tempCharArray))){
            return true;
        }




        return false;
    }
}
