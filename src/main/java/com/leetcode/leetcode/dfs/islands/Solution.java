package com.leetcode.leetcode.dfs.islands;


class Solution {



    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j ++){
                //only increment count if island seen
                if (grid[i][j] == '1'){
                    count += 1;
                    dfs(i , j, grid);
                }

            }
        }
        
        return count;
    }


    /**
     * recursive dfs function to mark all connected land as visited
     * @param row
     * @param column
     * @param grid
     */
    public void dfs(int row, int column, char[][]grid){
            grid[row][column] ='0';
            if (row+1 < grid.length && grid[row+1][column] == '1'){
                dfs(row+1, column, grid);
            }
            if (row > 0 && grid[row-1][column] == '1'){
                dfs(row-1, column, grid);
            }
            if (column+1 < grid[row].length && grid[row][column+1] == '1'){
                dfs(row, column+1, grid);
            }
            if (column >0 && grid[row][column-1] == '1'){
                dfs(row, column-1, grid);
            }
            return;
    }
}