package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> sol = new ArrayList<Integer>();
		helper(nums, ans, sol, 0);
		return ans;
        
    }
	
	public static void helper(int[] nums, List<List<Integer>> ans, List<Integer> sol, int index) {
		ans.add(new ArrayList<Integer>(sol));
		for(int i = index; i < nums.length; i++) {
			sol.add(nums[i]);
			helper(nums, ans, sol, i+1);
			sol.remove(sol.size() - 1);
		}
	}
}
