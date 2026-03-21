package com.leetcode.leetcode.dfs.islands.area;

/**
 * @author sajalgupta
 */
public class Solution {


    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < columns; j ++){
                if(grid[i][j]==1){
                    int areaOfIsland = dfs( i, j, grid);
                    maxArea = Math.max(maxArea, areaOfIsland);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int column, int[][]grid){
        grid[row][column] = 0;
        int area = 1;
        if (row+1 < grid.length && grid[row+1][column] == 1){
                area += dfs(row+1, column, grid);
            }
            if (row > 0 && grid[row-1][column] == 1){
                area += dfs(row-1, column, grid);
            }
            if (column+1 < grid[row].length && grid[row][column+1] == 1){
                area += dfs(row, column+1, grid);
            }
            if (column >0 && grid[row][column-1] == 1){
                area += dfs(row, column-1, grid);
            }
        return area;
    }
}
