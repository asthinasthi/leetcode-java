package org.leetcode.problems.medium;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int containsZero = 0;
        int allProductNonZero = 1;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                containsZero++;
            } else {
                allProductNonZero = allProductNonZero*nums[i];
            }
        }

        for(int j=0; j<nums.length; j++){
            if(containsZero == 0){
                result[j] = allProductNonZero/nums[j];
            } else if(containsZero == 1){
                if(nums[j] == 0){
                    result[j] = allProductNonZero;
                } else {
                    result[j] = 0;
                }
            } else {
                result[j] = 0;
            }
        }
        return result;
    }
}
