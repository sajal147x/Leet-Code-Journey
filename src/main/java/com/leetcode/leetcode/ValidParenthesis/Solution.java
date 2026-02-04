package com.leetcode.leetcode.ValidParenthesis;

import java.util.Stack;

/**
 * @author sajalgupta
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //Preliminary check for even length
        if(s.length() % 2!=0){
            return false;
        }


        //USE STACK TO CHECK FOR VALIDITY
        for(int i = 0; i < s.length(); i ++){
            char x = s.charAt(i);
            if(x =='(' || x =='[' || x == '{'){
                stack.push(x);
            }
            if(x == ')' || x == ']' || x == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char last = stack.pop();
                if (x == ')' && last!='('){
                    return false;
                }
                if (x == ']' && last!='['){
                    return false;
                }
                if (x == '}' && last!='{'){
                    return false;
                }
            }
        }
        
        //Final check
        if (!stack.isEmpty()){
            return false;
        }
        return true;


    }
}