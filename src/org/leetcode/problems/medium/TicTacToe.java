package org.leetcode.problems.medium;

import com.sun.javafx.animation.TickCalculation;
import org.junit.Test;

public class TicTacToe {

    char[][] board;
    boolean[][] visited;
    int SIZE;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
        visited = new boolean[n][n];
        SIZE = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins.
     Player1 - X
     Player2 - 0
     */
    public int move(int row, int col, int player) {
        int result = 0;
        if(player == 1){
            board[row][col] = 'X';
            result = checkWin(row, col, 'X')?1:0;
        } else {
            board[row][col] = '0';
            result = checkWin(row, col, '0')?2:0;
        }
        return result;
    }

    public boolean checkWin(int x, int y, char c){
        return isVerticalLinedUp(x, y, c) || isHorizontalLinedUp(x, y, c)
                || isDiagonal1LinedUp(x, y, c) || isDiagonal2LinedUp(x, y, c);
    }
    public boolean isVerticalLinedUp(int x , int y, char c){
        //vertical
        for (int i = 0; i < SIZE; i++) {
            if(board[x][i] !=c){
                return false;
            }
        }
        return true;
    }

    public boolean isHorizontalLinedUp(int x , int y, char c){
        //vertical
        for (int i = 0; i < SIZE; i++) {
            if(board[i][y] !=c){
                return false;
            }
        }
        return true;
    }

    public boolean isDiagonal1LinedUp(int x , int y, char c){
        //vertical
        for (int i = 0; i < SIZE; i++) {
            if(board[i][i] !=c){
                return false;
            }
        }
        return true;
    }

    public boolean isDiagonal2LinedUp(int x , int y, char c){
        //vertical
        for (int i = 0; i < SIZE; i++) {
            int j=SIZE-i-1;
            if(board[i][j] !=c){
                return false;
            }
        }
        return true;
    }
}
