package org.leetcode.problems.hard;

import org.junit.Ignore;
import org.junit.Test;

public class AutocompleteSystemTest {

//    @Test
    public void test2(){
        String[] sentences = new String[]{"i love you","island","ironman","i love leetcode"};
        int[] times = new int[]{5,3,2,2};

        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));

    }

    @Test
    public void test(){
        String[] sentences = new String[]{"abc", "abbc", "a"};
        int[] times = new int[]{3,3,3};
//[null,[],[],[],["bc"],["bc"],[],["a","abbc","abc"],["abbc","abc"],["abc"],[],["abc","a","abbc"],["abc","abbc"],["abc"],[]]
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
        System.out.println(autocompleteSystem.input('b'));
        System.out.println(autocompleteSystem.input('c'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('b'));
        System.out.println(autocompleteSystem.input('c'));
        System.out.println(autocompleteSystem.input('#'));
//        System.out.println(autocompleteSystem.input('a'));
//        System.out.println(autocompleteSystem.input('b'));
//        System.out.println(autocompleteSystem.input('c'));
//        System.out.println(autocompleteSystem.input('#'));
//        System.out.println(autocompleteSystem.input('a'));
//        System.out.println(autocompleteSystem.input('b'));
//        System.out.println(autocompleteSystem.input('c'));
//        System.out.println(autocompleteSystem.input('#'));

    }

//    @Test
    public void test3(){
        String[] sentences = new String[]{"i love you","island","iroman","i love leetcode"};
        int[] times = new int[]{5,3,2,2};

        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);
    }
}
