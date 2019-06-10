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
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
       for(int i = 1; i < nums.length; i++){
           if(nums[i] < nums[i-1]){
               min = Math.min(min, nums[i]);
               max = Math.max(max, nums[i-1]);
           }
       }
        if(min == Integer.MAX_VALUE) return 0;
        int left = 0, right = nums.length-1;
        while(nums[left] <= min) left++;
        while(nums[right] >= max) right--;
        
        return right-left+1;
    }
}
