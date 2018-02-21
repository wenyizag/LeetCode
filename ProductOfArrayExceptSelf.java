package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ProductOfArrayExceptSelf {
	//Solution 1	
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] left = new int[len];
		int[] right = new int[len];
		int[] ans = new int[len];
		
        left[0] = 1;
		for(int i = 1; i<len; i++)
			left[i] = nums[i-1]*left[i-1];
		
        right[len-1] = 1;
		for(int i = len-2; i>=0; i--)
			right[i] = nums[i+1]*right[i+1];
	
		for(int i = 0; i<len; i++)
			ans[i] = left[i]*right[i];
         
		return ans;
    }
	
	//Optimization
	public static int[] productExceptSelf2(int[] nums) {
		int len = nums.length;
		int[] ans = new int[len];
		
        ans[0] = 1;
		for(int i = 1; i<len; i++)
			ans[i] = nums[i-1]*ans[i-1];
		
		int right = 1;
		for(int i = len-1; i>=0; i--) {
			ans[i] = right*ans[i];
			right = right*nums[i];
		}
         
		return ans;
    }
}
