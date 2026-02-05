package com.leetcode.leetcode.dfs.BinaryTreeMaxDepth;

import java.util.Stack;

import com.leetcode.leetcode.dfs.TreeNode;

/**
 * @author sajalgupta
 */

class Solution {
	public int maxDepth(TreeNode root) {
		// HANDLE BASE CASES
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		// ACTUAL IMPLEMENTATION
		Stack<TreeNode> visited = new Stack<>(); // keep track of visited nodes
		Stack<Integer> depth = new Stack<>(); // keep track of depth
		visited.push(root);
		depth.push(1);

		int maxDepth = 0;

		while (!visited.isEmpty()) {
			TreeNode current = visited.pop();
			int currentDepth = depth.pop();

			maxDepth = Math.max(maxDepth, currentDepth);
			// LEFT
			if (current.left != null) {
				visited.push(current.left);
				depth.push(currentDepth + 1);
			}
			// RIGHT
			if (current.right != null) {
				visited.push(current.right);
				depth.push(currentDepth + 1);
			}
		}

		return maxDepth;

	}
}