package org.leetcode.problems.medium;

import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void test1(){
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }

    @Test
    public void test(){
        System.out.println("Test2 ********");
        TicTacToe toe = new TicTacToe(2);
        System.out.println(toe.move(0, 0, 2));
        System.out.println(toe.move(1, 1, 1));
        System.out.println(toe.move(0, 1, 2));
    }
}
