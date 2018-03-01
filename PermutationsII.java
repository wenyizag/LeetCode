package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PermutationsII {
	 public static List<List<Integer>> permute(int[] nums) {
		 ArrayList<List<Integer>> ans = new ArrayList<>();
		 if(nums.length == 0) return ans;
		 Arrays.sort(nums);
		 boolean[] used = new boolean[nums.length];
		 backtracking(nums, used, new ArrayList<Integer>(), ans);
		 return ans;
	 }

	 public static void backtracking( int[] nums, boolean[] used, ArrayList<Integer> cur, ArrayList<List<Integer>> ans) {
		 if(cur.size() >= nums.length) {
			 ans.add(new ArrayList<Integer>(cur));
			 return;
		 }
		 for(int i = 0; i < nums.length; i++) {
			 if(used[i]) continue;
			 cur.add(nums[i]);
			 used[i] = true;
			 backtracking(nums,used, cur, ans);
			 cur.remove(cur.size()-1);
			 used[i] = false;
			 while( i < nums.length -1 && nums[i] == nums[i+1]) i++;
		 }
	 }
	
	
	 
	 
}
