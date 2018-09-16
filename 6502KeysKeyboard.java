    public int minSteps(int n) {
        if(n <= 1) return 0;
        int[] dp = new int[n+1];
        //虽然这个方法不好，耗时O(n^2)，但是这个思路值得说一下，待会儿再讲一种优化的
        //这个题一看就是dp，所以套了个最最传统的两层for，然后观察i，如果从1一直复制到i，最多做操作i下
        //因为它这个copy只能copy全部的，所以如果j是i的除数的话，那i就可以通过j下到达i
        for(int i = 1; i <= n; i++){
            dp[i] = i;
            for(int j = 1; j < i; j++){
                if(i % j == 0 ){
                  dp[i] = Math.min(dp[j] + (i/j), dp[i]);  
                }
            }
        }
        return dp[n];
    }