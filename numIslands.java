/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
       int count = 0;
       int rows = grid.length;
       if(rows == 0) return 0; 
       int columns = grid[0].length;
       int[][] island = new int[rows+2][columns+2];
           
       for(int i = 0; i < rows; i++) {
           for(int j = 0; j < columns; j++) {
               if(grid[i][j] == '1') {
                   int si = i+1, sj = j+1;
                   if((island[si][sj-1] > 0) && (island[si-1][sj] > 0)) {
                       int min = Math.min(island[si][sj-1], island[si-1][sj]);
                       if(island[si][sj-1] != island[si-1][sj]) {
                           if(island[si][sj-1] > island[si-1][sj]) {
                              for(int k = sj-1; island[si][k] > min; k--) {
                                island[si][k] = min;
                              }
                           } else {
                              for(int k = sj; island[si-1][k] > min; k++) {
                                island[si-1][k] = min;
                              }
                           }
                               
                           count--;
                       }
                       island[si][sj] = min;
                    
                   } else if((island[si][sj-1] > 0) || (island[si-1][sj] > 0)) {
                       island[si][sj] = Math.max(island[si][sj-1], island[si-1][sj]);   
                   } else {
                       count++;
                       island[si][sj] = count;
                   }                   
               }
           }
       }
        
       return count;
    }
}
