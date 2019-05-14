package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {
    int[] coins = new int[]{86,419,83,408};
//    int[] coins = new int[]{1,2,5};
    @Test
    public void test(){

//        int amount = 11;
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if(amount <= 0 || coins == null || coins.length == 0 ){
            return 0;
        }
        int[] minNumber = new int[amount+1];
        for(int amt=1; amt<amount+1; amt++){
            minNumber[amt] = Integer.MAX_VALUE;
            for(int i=0; i<coins.length; i++){
                int coin = coins[i];
                if(coin<=amt && minNumber[amt-coin]!=Integer.MAX_VALUE){
                    minNumber[amt] = Math.min(minNumber[amt], 1+minNumber[amt-coin]);
                }
            }
        }
        minNumber[amount] = minNumber[amount]==Integer.MAX_VALUE?-1:minNumber[amount];
        return minNumber[amount];
    }
}
