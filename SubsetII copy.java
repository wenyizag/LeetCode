package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SubsetII {
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        backtracking(0, nums, new ArrayList<Integer>(), ans);
        return ans;
    }
	
	public static void backtracking(int start, int[] nums, ArrayList<Integer> cur, ArrayList<List<Integer>> ans){
		ans.add(new ArrayList<Integer>(cur));
		for(int i = start; i < nums.length; i++) {
			cur.add(nums[i]);
			backtracking(i+1, nums, cur, ans);
			cur.remove(cur.size()-1);
			while(i < nums.length - 1 && nums[i] == nums[i+1]) i++;
		}
	}
	 
	 
}
