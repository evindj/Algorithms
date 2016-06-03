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
public class Island {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int columns = grid[0]. length;
        int res =0;
        for(int i =0; i< rows; i++){
            for(int j=0; j< columns; j++){
                if(grid[i][j] == '1'){
                    navigate(i , j, grid, rows, columns);
                    res++;
                }
            }
        }
        return res;
    }
    public void navigate(int i , int j, char[][] grid, int rows, int columns){
            grid[i][j] = '0';
            if(i>0 && grid[i-1][j] == '1' )
                navigate(i-1 , j, grid, rows, columns);
            if(j>0 && grid[i][j-1] == '1')
                navigate(i , j-1, grid, rows, columns);
            if(i<rows -1 && grid[i+1][j] == '1')
                navigate(i+1, j, grid, rows, columns);
            if(j< columns -1 && grid[i][j+1] == '1')
                navigate(i , j+1, grid, rows, columns);
    }
}
