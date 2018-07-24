
public class MinSubArraySum {

	public static void main(String[] args) {
		int[] arr = new int[]{34, 5 ,6 ,7, 29, 35, 3 , 2};
		int k = 33;
		System.out.println(minSubArray(arr, k));
	}
	
	public static int minSubArray(int[] arr, int k){
		int sum = 0;
		int startIdx = 0;
		int currIdx = 0;
		int minSum = Integer.MAX_VALUE;
		
		if(arr == null || arr.length == 0)
			return 0;
		
		while(startIdx < arr.length && currIdx < arr.length){
			sum+= arr[currIdx++];
			if(sum > k){
				if(currIdx - startIdx == 1){
					return arr[startIdx];
				}
				while(startIdx < currIdx){
					sum = sum - arr[startIdx++];
					if(sum < k)
						break;
					minSum = Math.min(sum, minSum);
				}
			}
		}
		System.out.println("Min Sub Array is: " + startIdx + " " + currIdx);
		System.out.println("Min Sub Array sum: " + minSum);
		return minSum;
	}
}
