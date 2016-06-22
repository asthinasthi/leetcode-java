package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class YapStone {

	@Test
	public void test() {
		int[] a = {6,7,9,5,6,3,2};
//		System.out.println(maxDifference(a));
		
		String s = "He had had quite";
		System.out.println(firstRepeatedWord(s));
//		System.out.println(super.getClass().getSuperclass().getName());
	}
	
	 static int maxDifference(int[] a) {
		 if(a.length<2){
			 return -1;
		 }
		 int size = a[0];
		 
		 //find Min So Far
		 // Keep Taking differences
		 int minSoFar = a[1];
		 int maxDiffSoFar = -1;
		 for(int i=2; i<a.length;i++){
			 minSoFar = Math.min(minSoFar, a[i]);
			 maxDiffSoFar = Math.max(maxDiffSoFar, a[i]-minSoFar);
		 }
		 if(maxDiffSoFar <0){
			 return -1;
		 }
		 return maxDiffSoFar;
	 }

/*	 class Adder extends Arithmetic{
		 public int add(int a, int b){
			 System.out.println("My super class is: " + super.getClass().getName());
			 System.out.println("42 " +"13 " +"20");
		 }
	 }*/

	   static String firstRepeatedWord(String s) {
//		   String[]tokens = s.split( "[\\s,:;-.]");
		   s.replaceAll("\\.", "\\s");
		   String[]tokens = s.split( "[\\s,:;-]");
		   Set<String> stringSet = new HashSet<String>();
		   
		   for(String t: tokens){
			   if(!stringSet.add(t)){
				   return t;
			   }
		   }
		   return "";
	    }
}
