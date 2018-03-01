package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		 ArrayList<List<Integer>> ans = new ArrayList<>();
		 if(nums.length == 0) return ans;
		 backtracking(nums, new ArrayList<Integer>(), ans);
		 return ans;
	 }

	 public static void backtracking( int[] nums, ArrayList<Integer> cur, ArrayList<List<Integer>> ans) {
		 if(cur.size() >= nums.length) {
			 ans.add(new ArrayList<Integer>(cur));
			 return;
		 }
		 for(int i = 0; i < nums.length; i++) {
			 if(cur.contains(nums[i])) continue;
			 cur.add(nums[i]);
			 backtracking(nums, cur, ans);
			 cur.remove(cur.size()-1);
		 }
	 }
}
