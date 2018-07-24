/**
 * 
 */
package org.leetcode.algorithms.arrays;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class CombiSum {

	@Test
	public void test() {
//		int[] candidates = new int[]{2, 3, 4, 7 };
//		int[] candidates = new int[]{7, 3 };
		int[] candidates = new int[]{2, 4, 6 };
		int target = 8;
		
		System.out.println(combinationSum(candidates, target));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		Arrays.sort(candidates);
		findSum(candidates, target, resultList, combination, 0);
		return resultList;
	}
	
	public void findSum(int[] candidates, int target, List<List<Integer>> resultList, 
						List<Integer> combination, int start ){
		if(target == 0){
			resultList.add(new ArrayList<Integer>(combination));
		} else if(target > 0){
			for(int i= start; i<candidates.length && target >= candidates[i]; i++){
				combination.add(candidates[i]);
				findSum(candidates, target - candidates[i], resultList, combination, i);
				combination.remove(combination.size() - 1);
			}
		}
	}
}
