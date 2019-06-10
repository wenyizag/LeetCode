    public int lenLongestFibSubseq(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for(int i = 0; i < len; i++) map.put(A[i], i);
        
        int[][] dp = new int[len][len];
        for(int[] cur: dp) Arrays.fill(cur, 2);
        
        int ans = 0;
        for(int i = 1; i < len-1; i++){
            for(int j = i + 1; j < len; j++){
                int pre = A[j] - A[i];
                //这一句过滤器很重要，遵循严格单调递增
                if(pre >= A[i]) continue;
                if(map.containsKey(pre)){
                    dp[i][j] = Math.max(dp[i][j], dp[map.get(pre)][i] + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        
        return ans;
    }
