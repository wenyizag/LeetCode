	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for(int i : nums) {
			sum += i;
		}
		if(sum % 2 != 0) return false;
		sum /= 2;
		//System.out.println(sum);
		
		boolean[] dp = new boolean[sum+1];
		dp[0] = true;
		
        //我之前有两个疑惑，一是为什么要把nums[0]~nums[n]放到外层循环，而把 0~sum 放到inner呢，
        //这是因为把nums放到外层，能保证nums[i]不被重复计算
        //二是为什么j要从sum从高到低计算，这是因为j必须大于nums[i], 在结尾贴一段测试代码
		for(int i = 0; i < nums.length; i++) {
			for(int j = sum; j >= nums[i] ; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
                if(dp[sum]) return true;
			}
			
		}
		
		return dp[sum];	
        
        //测试{1,5, 11 ,5};
        //inner for的输出：
        
        // nums[i] = 1
        // dp[11] false
        // dp[10] false
        // dp[9] false
        // dp[8] false
        // dp[7] false
        // dp[6] false
        // dp[5] false
        // dp[4] false
        // dp[3] false
        // dp[2] false
        // dp[1] true
        
        // nums[i] = 5
        // dp[11] false
        // dp[10] false
        // dp[9] false
        // dp[8] false
        // dp[7] false
        // dp[6] true
        // dp[5] true
        
        // nums[i] = 11
        // dp[11] true
        // nums[i] = 5
        // dp[11] true
        // dp[10] true
        // dp[9] false
        // dp[8] false
        // dp[7] false
        // dp[6] true
        // dp[5] true
        // true
	}