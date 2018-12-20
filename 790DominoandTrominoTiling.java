    public int numTilings(int N) {
        if(N == 1) return 1;
        int kMod = (int)(1e9 + 7);
        long[][] dp = new long[N][3];
        dp[0][0] = 1;
        dp[1][0] = 2; dp[1][1] = 1; dp[1][2] = 1;
        
        for(int i = 2; i < N; i++){
            dp[i][0] = (dp[i-2][0] + dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % kMod;
            dp[i][1] = (dp[i-2][0] + dp[i-1][2]) % kMod;
            dp[i][2] = (dp[i-2][0] + dp[i-1][1]) % kMod;
        }
        
        return (int)dp[N-1][0];
    }