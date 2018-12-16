	public static boolean canPartition(int[] nums) {
        if(nums.length <= 1) return false;
        int sum = 0;
        for(int num : nums) sum += num;
        
        if((sum & 1) == 1) return false;
        
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > sum) return false;
            for(int j = sum; j >= 0; j--){
                if(dp[j] && j + nums[i] <= sum) dp[j+nums[i]] = true;
                if(dp[sum]) return true;
            }
        }
        
        return dp[sum];  
    }