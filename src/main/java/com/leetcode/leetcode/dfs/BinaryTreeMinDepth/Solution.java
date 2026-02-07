package com.leetcode.leetcode.dfs.BinaryTreeMinDepth;


import com.leetcode.leetcode.dfs.TreeNode;

import java.util.Stack;

/**
 * @author sajalgupta
 */
class Solution {
    public int minDepth(TreeNode root) {
        Stack<TreeNode> visited = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        int minDepth = 9999999; //arbitrary large number
        //BASE CASES
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        visited.add(root);
        depth.add(1);
        //TRAVERSAL
        while (!visited.isEmpty()){
            TreeNode current = visited.pop();
            Integer currentDepth = depth.pop();

            if (current.left == null && current.right==null){
                minDepth = Math.min(currentDepth, minDepth);
            }
            if(current.left !=null){
                visited.push(current.left);
                depth.push(currentDepth+1);
            }

            if(current.right!=null){
                visited.push(current.right);
                depth.push(currentDepth+1);
            }


        }

        return minDepth;


    }

    public static void main(String[] args) {
        System.out.println("TEST");
    }
}