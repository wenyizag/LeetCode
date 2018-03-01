package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Combinations {
	
	//backtracking
	public static List<List<Integer>> combine(int n, int k) {
		 ArrayList<List<Integer>> ans = new ArrayList<>();
		 if(n == 0) return ans;
		 backtracking(n,k,1, new ArrayList<Integer>(), ans);
		 return ans;
	 }

	 public static void backtracking( int n, int k,int start, ArrayList<Integer> cur, ArrayList<List<Integer>> ans) {
		 if(k == 0) {
			 ans.add(new ArrayList<Integer>(cur));
			 return;
		 }
		 for(int i = start; i <= n; i++) {
			 //if(cur.contains(i)) continue;
			 cur.add(i);
			 backtracking(n,k-1,i+1, cur, ans);
			 cur.remove(cur.size()-1);
		 }
	 }

	
	
	 
	 
}
