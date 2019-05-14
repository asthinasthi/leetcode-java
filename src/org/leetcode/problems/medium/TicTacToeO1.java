package org.leetcode.problems.medium;

public class TicTacToeO1 {
    int[] rowSum;
    int[] colSum;
    int diagonal1Sum;
    int diagonal2Sum;
    int SIZE;
    /** Initialize your data structure here. */
    public TicTacToeO1(int n) {
        SIZE = n;
        rowSum = new int[SIZE];
        colSum = new int[SIZE];
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
        int sum = player==1?-1:1;
        rowSum[row]+=sum;
        colSum[col]+=sum;

        if(row == col){
            diagonal1Sum+=sum;
        }

        if(row == SIZE-col-1){
            diagonal2Sum+=sum;
        }

        if(Math.abs(rowSum[row]) == SIZE
            ||Math.abs(colSum[col]) == SIZE
            ||Math.abs(diagonal1Sum) == SIZE
            ||Math.abs(diagonal2Sum) == SIZE){
            return sum==-1?1:2;
        }

        return 0;
    }

}
