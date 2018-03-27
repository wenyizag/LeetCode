package leetcode;

public class ShortestUnsortedContinuousSubarray {
	// one pass
	 public int findUnsortedSubarray(int[] nums) {
	        int start = -2, end = -1;
	        int min = nums[nums.length - 1], max = nums[0];
	        for(int i = 1, j = nums.length-2; i < nums.length; i++,j--){
	            min = Math.min(min, nums[j]);
	            max = Math.max(max, nums[i]);
	            if(nums[j] > min) end = j;
	            if(nums[i] < max) start = i;
	        }
	        return start - end + 1;
	    }
	 
	 //two pass
	   public static int findUnsortedSubarray2(int[] nums) {
	        int start = 0, end = nums.length - 1;
	        while( start < nums.length-1 && nums[start] <= nums[start+1]){
	            start++;
	        }
	        if(start == nums.length-1) return 0;
	        while(end >= 1 && nums[end-1] <= nums[end]){
	            end--;
	        }
	        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	        for(int i = start; i <=end; i++){
	            min = Math.min(min, nums[i]);
	            max = Math.max(max, nums[i]);
	        }
	        
	        while(end < nums.length && nums[end] < max) end++;
	        while(start >= 0 && nums[start] > min) start--;
	        
	        return end-start-1;
	  }
}
