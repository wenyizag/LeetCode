package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		helper(nums, ans, new ArrayList<Integer>());
        return ans;
    }
	
	public static void helper(int[] nums, List<List<Integer>> ans, ArrayList<Integer> sol){
		if(sol.size() == nums.length) {
			ans.add(new ArrayList<Integer>(sol));
		}else {
			for(int i = 0; i < nums.length; i++) {
				if(sol.contains(nums[i])) continue;
				sol.add(nums[i]);
				helper(nums, ans, sol);
				sol.remove(sol.size() - 1);
			}
		}
		
	}
}
