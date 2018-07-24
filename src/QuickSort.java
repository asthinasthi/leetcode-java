
public class QuickSort {

	public static void main(String[] args) {
		int nums[] = {4,5,2,3,1,6,7,8};
		sort(nums, 0, nums.length-1);
	}
	
	public static void sort(int[] nums, int low, int high){
		int i = low;
		int j = high;
		int pivot = low + (high-low)/2;
		int pivot_val = nums[pivot];
		
		while(i<=j){
			while(nums[i] < pivot_val){
				i++;
			}
			
			while(nums[j] > pivot_val){
				j--;
			}
			
			if(i<=j){
				swap(nums ,i, j);
				i++;
				j--;
			}
		}
		if(low < j)
			sort(nums, low, j);
		if(i < high)
			sort(nums, i, high);
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
