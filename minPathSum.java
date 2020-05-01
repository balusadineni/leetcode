/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int columns = grid[0].length;
        
        
        for(int i=1;i<columns;i++) grid[0][i] += grid[0][i-1];
        for(int i=1;i<rows;i++) grid[i][0] += grid[i-1][0];
        for(int i=1;i<rows;i++)
            for(int j=1;j<columns;j++)
              grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        
        return grid[rows-1][columns-1];
    }
}
