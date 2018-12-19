    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for(int[] cur : dp) Arrays.fill(cur, Integer.MIN_VALUE);
        DP(piles, 0, len-1, dp);
        return dp[0][len-1] > 0;
    }
    
    public int DP(int[] piles, int s, int e, int[][] dp){
        if(s == e){
            dp[s][e] = piles[s];
            return dp[s][e];
        }
        if(dp[s][e] != Integer.MIN_VALUE) return dp[s][e];
      
        dp[s][e] = Math.max(piles[e] - DP(piles, s, e-1, dp), 
                            piles[s] - DP(piles, s+1, e, dp));
        
        return dp[s][e];
    }