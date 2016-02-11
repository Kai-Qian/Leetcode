/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
dfs O(NM)
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int size1 = grid.length;
        int size2 = grid[0].length;
        int ans = 0;
        for(int i = 0; i < size1; i++) {
            for(int j = 0; j < size2; j++) {
                if(grid[i][j] != '1') {
                    continue;
                } else {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}