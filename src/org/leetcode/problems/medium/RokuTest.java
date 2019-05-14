package org.leetcode.problems.medium;

import org.junit.Test;

public class RokuTest {

    // in place swap
    // char[] {a, b, c, d}
    // dest[] {3, 0, 1, 2}
    // output[] {b, c, d, a}

    // i=0
    // a 3
    // destIdx = dest[i]
    // currDest = char[destIdx] nextDest =  dest[destIdx]
    // nextV = d nextIdx = 3

    @Test
    public void test(){

        char[] input = new char[]{'a', 'b', 'c', 'd'};
        int[] dest = new int[]{3,0,1,2};
        char[] expectedOutput = new char[]{'b','c','d','a'};

        swap(input, dest);
        print(input);
    }

    public void swap(char[] input, int[] dest){
        int currI=0,nextI = dest[currI];
        int N = input.length;
        char curr = input[currI];
        while (nextI < N){
            char temp = input[nextI];
            input[nextI] = curr;
            curr = temp;
            dest[currI] = N;
            currI = nextI;
            nextI = dest[nextI];
        }
    }

    public void print(char[] input){
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
    }
}
