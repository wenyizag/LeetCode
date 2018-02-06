package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		 int[] ans = new int[2];
		 HashMap<Integer, Integer> map = new HashMap();
		 
		 for(int i = 0; i < nums.length; i++) {
			 if(map.containsKey(target-nums[i])) {
				 ans[0] = map.get(target-nums[i]);
				 ans[1] = i;
				 return ans;
			 }
			 map.put(nums[i], i);
		 }	
		return ans;		 
	 }
}
