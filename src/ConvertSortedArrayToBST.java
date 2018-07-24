
public class ConvertSortedArrayToBST {

	public static void main(String[] args){
		int nums[] = {1,2,3,4,5,6,7,8,9,10};
		ConvertSortedArrayToBST object = new ConvertSortedArrayToBST();
		object.sort(nums, 0, nums.length-1);
	}
	
	public TreeNode sort(int nums[], int begin , int end){
		if(nums.length == 0){
			return null;
		}
		
		int val = nums[nums.length/2];
		TreeNode node = new TreeNode(val);
		node.left = sort(nums, begin, begin+(end-begin)/2);
		node.right = sort(nums, begin+(end-begin)/2+1, end);
		return node;
	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
}
