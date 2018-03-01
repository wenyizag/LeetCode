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
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(candidates.length == 0) return ans;
        Arrays.sort(candidates);
        backTracking(0, target, candidates, new ArrayList<Integer>(), ans);
        return ans;
    }
	
	public static void backTracking(int index, int target, int[] candidates, 
			                 ArrayList<Integer> cur, ArrayList<List<Integer>> ans) {
		if(target == 0) {
			ans.add(new ArrayList<Integer>(cur));
            return;
		}
		for(int i = index; i < candidates.length && target >= candidates[i]; i++) {
			//if(i > index && candidates[i] == candidates[i-1]) continue;
			cur.add(candidates[i]);
			backTracking(i, target-candidates[i], candidates, cur, ans);
			cur.remove(cur.size()-1);			
		}
	}
	 
	 
}
