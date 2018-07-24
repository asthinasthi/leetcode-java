package org.leetcode.problems.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramMappings {

    @Test
    public void test(){
        int[] A = new int[]{12, 28, 46, 32, 50};
        int[] B = new int[]{50, 12, 32, 46, 28};
        int[] result = anagramMappings(A, B);
        System.out.println(Arrays.toString(result));
    }

    public int[] anagramMappings(int[] A, int[] B) {
        int[] mappings = new int[A.length];
        //load B into hashmap of
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i< B.length; i++ ){
            map.put(B[i],i);
        }

        for(int i=0; i < A.length; i++){
            int index = map.get(A[i]);
            mappings[i] = index;
        }
        return  mappings;
    }
}
