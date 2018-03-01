package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Subset {
	
	//backtracking
	public static List<List<Integer>> subsets(int[] nums) {
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
		}
	}
	
	
	//iteration
	public static List<List<Integer>> subsets2(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        ans.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
        		int size = ans.size();
        		for(int j = 0; j < size; j++) {
        			ArrayList<Integer> tmp= new ArrayList(ans.get(j));
        			tmp.add(nums[i]);
        			ans.add(tmp);       			
        		}       			
        }
        return ans;      
	}
	 
	 
}
