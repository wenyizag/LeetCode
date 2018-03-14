package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SubarraySumEqualsK {
	
	//HashMap
	public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
        		sum += nums[i];
        		if(map.containsKey(sum-k)) {
        			count += map.get(sum-k);
        		}
        		map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
	
	
	//cumulative sum with array	
	public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++)
        		sum[i] = sum[i-1] + nums[i-1];
        for(int start = 0; start < nums.length; start++) {
        		for(int end = start+1; end <= nums.length; end++) {
        			if(sum[end] - sum[start] == k) count++;
        		}
        }
        return count;
    }
	
	//cumulative sum without space
	public static int subarraySum3(int[] nums, int k) {
        int count = 0;
        for(int start = 0; start < nums.length; start++) {
        		int sum = 0;
        		for(int end = start; end < nums.length; end++) {
        			sum += nums[end];
        			if(sum==k) count++;
        		}
        }
        return count;
    }
}
