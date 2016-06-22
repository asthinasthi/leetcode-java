/**
 * 
 */

/**
 * @author amathad
 *
 */
public class MinInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {4,5,6,1,2,3};
//		int[] inputArray = {1,2,3,4,5,6,7};
//		int[] inputArray = {2,3,4,5,6,1};
		System.out.println(findMinFast(inputArray));
	}
	
	public static int findMinFast(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		
		return find(nums, 0, nums.length-1);
	}
	
	public static int find(int[] nums, int beginIdx, int lastIdx){
		if(nums[beginIdx] <= nums[lastIdx]){
			return nums[beginIdx];
		}
		return Math.min(find(nums, beginIdx, beginIdx+(lastIdx-beginIdx)/2), find(nums, beginIdx+(lastIdx-beginIdx)/2+1, lastIdx));
	}
	
	public static int findMin(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		for(int i=0; i<nums.length-1;i++){
			if(nums[i] > nums[i+1]){
				return nums[i+1];
			}
		}
		return nums[0];
	}

}
