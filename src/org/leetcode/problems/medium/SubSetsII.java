package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SubSetsII {

	@Test
	public void test() {
		int[] nums = {1, 2, 2, 3};
		for(List<Integer>i: findSubsets(nums))
			System.out.println(i);
	}

	private List<List<Integer>> findSubsets(int[] nums){
		if(nums == null)
			return new ArrayList<List<Integer>>();
		List<Integer> numsList = new ArrayList<Integer>();
		for(int i:nums)
			numsList.add(i);
		Collections.sort(numsList);
		List<List<Integer>> resultList = new ArrayList<>();
		for(int i : numsList){
			ArrayList<ArrayList<Integer>> tempList = new ArrayList<ArrayList<Integer>>();
			for(List<Integer> a : resultList){
				tempList.add(new ArrayList<Integer>(a));//create new list out of existing list
			}
			for(ArrayList<Integer> everyList : tempList){
				everyList.add(i);
			}
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(i);
			tempList.add(single);
			resultList.addAll(tempList);
		}
		resultList.add(new ArrayList<Integer>());
		Set<List<Integer>> resultSet = new HashSet<>();
		resultSet.addAll(resultList);
		
		resultList = new ArrayList<List<Integer>>(resultSet);
		return resultList;
	}
	
}
