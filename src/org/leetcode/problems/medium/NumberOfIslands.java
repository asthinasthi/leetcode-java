package org.leetcode.problems.medium;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

public class NumberOfIslands {

    @Test
    public void test(){
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    int ROWS,COLS;
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ROWS = grid.length;
        COLS = grid[0].length;
        int islands = 0;
        for(int x=0; x<ROWS; x++){
            for (int y = 0; y < COLS; y++) {
                if(!visited[x][y])
                    islands+=isIsland(grid, visited, x, y);
            }
        }
        return islands;
    }

    public int isIsland(char[][] grid, boolean[][] visited, int x, int y){
        if(grid[x][y] == '1'){
            bfs(grid, visited, x , y );
            return 1;
        } else {
            return 0;
        }
    }

    public void bfs(char[][] grid, boolean[][] visited, int x, int y){

        if(x<0 || x>=ROWS || y<0 || y>=COLS){
            return;
        }

        if(!visited[x][y] && grid[x][y] == '1'){
            visited[x][y] = true;
            //left
            bfs(grid, visited, x-1, y);
            //right
            bfs(grid, visited, x+1, y);
            //up
            bfs(grid, visited, x, y-1);
            //down
            bfs(grid, visited, x, y+1);
        }
    }
}
