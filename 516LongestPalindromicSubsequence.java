    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] c = s.toCharArray();
        int ans = 1;
        
        //注意这里只能是倒叙，因为计算dp[i][j]的时候，必须将其用到的dp[i+1][j-1], dp[i][j-1],
        //dp[i+1][j]都已经计算过
        for(int i = len-1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++){
                if(c[i] == c[j]) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        
        return dp[0][len-1];
    }