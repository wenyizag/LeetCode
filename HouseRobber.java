package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class HouseRobber {
	//Solution 1. DP Array
	public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
        		dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
	
	//solution 2. two Variable
	public int rob2(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for(int i = 0; i < nums.length; i++) {
        		if(i%2 == 0)  rob = Math.max(rob + nums[i], notRob);
        		else notRob = Math.max(notRob + nums[i], rob);
        }
        return Math.max(rob, notRob);
    }
}
