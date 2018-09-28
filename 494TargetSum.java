    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) sum+=num;
        if(S > sum || S < -sum) return 0;
        int[] dp = new int[sum*2+1];
        //和为0
        dp[0 + sum] = 1;
        for(int i = 0; i < nums.length; i++){
            int[] next = new int[sum*2+1];
            for(int j = 0; j < sum*2+1; j++){
                if(dp[j] != 0){
                    next[j+nums[i]] += dp[j];
                    next[j-nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[S+sum];
    }


        //数据规模很小的时候的暴力作法，DFS，不可取。。
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, S, 0, 0);
        return ans;
    }
    public void helper(int[] nums, int S, int index, int sum){
        if(index >= nums.length){
            if(sum == S) ans+=1;
            return;
        }
        helper(nums, S, index+1, sum+nums[index]);
        helper(nums, S, index+1, sum-nums[index]);
    }