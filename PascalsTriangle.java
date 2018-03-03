package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans=new ArrayList<>();
        if(numRows <= 0) return ans;
        ans.add(new ArrayList<Integer>());
        ans.get(0).add(1);
        for(int i = 1; i < numRows; i++) {
        		List<Integer> pre = ans.get(i-1);
			List<Integer> cur = new ArrayList<Integer>();
			
			//head = 1;
			cur.add(1);
        		for(int j = 1; j < i; j++) {
        			cur.add(pre.get(j) + pre.get(j-1));
        		}
        		
        		//tail = 1;
        		cur.add(1);
        		ans.add(cur);
        }
        return ans;        
    }	 
}
