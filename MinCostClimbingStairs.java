package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MinCostClimbingStairs {
	//Solution 1
	public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
        		dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
	}
	
	//solution 2
	public int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0; 
        dp[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
        		dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
 }
}
