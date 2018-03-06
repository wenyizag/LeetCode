package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<Integer>();
		if(rowIndex < 0) return ans;
		
		for(int i = 0; i < rowIndex+1; i++) {
			ans.add(0, 1);
			for(int j = 1; j < ans.size()-1; j++) {
				ans.set(j, ans.get(j) + ans.get(j+1));
			}
		}
		return ans;
    }	 
}
