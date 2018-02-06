package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++) {
			//i去重
			if(i == 0 || (i>0 && nums[i]!=nums[i-1])) {
				int low = i+1, high = nums.length-1, sum = 0-nums[i];
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while(low < high && nums[low] == nums[low+1]) low++;
						while(low < high && nums[high] == nums[high-1]) high--;
						low++;
						high--;
					}else if(nums[low] + nums[high] < sum) {
						low++;
					}else {
						high--;
					}
				}
			}
		}
		return ans;
	}
}
