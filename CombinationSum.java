package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CombinationSum {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> ans = new ArrayList<>();
		if(candidates.length == 0) return ans;
        Arrays.sort(candidates);
		backtracking(target, 0, candidates, new ArrayList<Integer>(), ans);
		return ans;
	}
	public static void backtracking(int target, int start, int[] candidates,
								  ArrayList<Integer> cur, ArrayList<List<Integer>> ans) {
		if(target == 0) {
			ans.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i = start; i < candidates.length; i++) {
            if(target < candidates[i]) break;
			cur.add(candidates[i]);
			backtracking(target - candidates[i], i, candidates, cur, ans);
			cur.remove(cur.size() - 1);
		}
	}
	 
	 
}
