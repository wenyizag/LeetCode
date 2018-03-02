package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] fact = new int[n+1];  // factorial
        fact[0] = 1;
        for (int i = 1; i <= n; i++){
        		nums.add(i);
        		fact[i] = i*fact[i-1];
        }


        k = k-1;
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            ans.append(nums.get(ind));
            nums.remove(ind);
        }
        return ans.toString();
    }	 
}
