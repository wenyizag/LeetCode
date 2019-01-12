//Solution 1. DP
class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum < S || -sum > S) return 0;
        
        int[] dp = new int[2*sum + 1];
        dp[sum] = 1;
        
        for(int i = 0; i < nums.length; i++) {
            int[] next = new int[2*sum + 1];
            for(int j = nums[i]; j < dp.length - nums[i]; j++) {
                if(dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        
        return dp[S + sum];
    }

}

//Solution 2. DFS + memo 时间复杂度与solution 1一样
class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum < S || -sum > S) return 0;
        int[][] memo = new int[nums.length][2*sum + 1];
        for(int[] c : memo) 
            Arrays.fill(c, Integer.MIN_VALUE);
        return DFS(nums, 0, 0, S, memo, sum);
    }
    
    public int DFS(int[] nums, int i, int curSum, int S, int[][] memo, int sum) {
        if(i == nums.length) return (curSum == S) ? 1 : 0;
        
        if(memo[i][curSum + sum] != Integer.MIN_VALUE)
            return memo[i][curSum + sum];
        
        int add = DFS(nums, i + 1, curSum + nums[i], S, memo, sum);
        int sub = DFS(nums, i + 1, curSum - nums[i], S, memo, sum);
        memo[i][curSum + sum] = add + sub;
        
        // System.out.println(i + " " + curSum + " " +memo[i][curSum + sum]);
        
        return memo[i][curSum + sum];
    }

}