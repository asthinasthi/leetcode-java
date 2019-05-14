package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.*;

public class LetterCombinations {

    @Test
    public void test() {
        String digits = "234";
        List<String> results = letterCombinations(digits);
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i) + ", ");
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();

        Map<String, List<String>> numToLetMap = getNumToLetMap();
        if(digits.length() == 1)return numToLetMap.get(digits.substring(0,1));

        List<String> l1 = null;
        List<String> l2 = null;

        if(digits.length() > 2){
            int mid = digits.length()/2;
             l1 = letterCombinations(digits.substring(0, mid+1));
             l2 = letterCombinations(digits.substring(mid+1));
            return twoMul(l1, l2);
        } else {
            l1 = numToLetMap.get(digits.substring(0,1));
            l2 = numToLetMap.get(digits.substring(1));
            return twoMul(l1, l2);
        }
    }

    public Map<String, List<String>> getNumToLetMap() {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
        return map;
    }

    private List<String> twoMul(List<String> l1, List<String> l2){
        List<String> crossProduct = new ArrayList<>();

        for (int i = 0; i < l1.size() ; i++) {
            for (int j = 0; j < l2.size() ; j++) {
                crossProduct.add(l1.get(i)+l2.get(j));
            }
        }
        return crossProduct;
    }
}
