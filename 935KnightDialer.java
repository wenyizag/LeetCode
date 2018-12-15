    public static final int kMod = 1000000007;
    public int knightDialer(int N) {
        int[][] pres = {{4, 6}, {8, 6}, {7, 9}, {4, 8},
                         {3, 9, 0}, {}, {0, 7, 1}, {2, 6},
                         {1, 3}, {2, 4}};
        
        int[][] memo = new int[N][10];
        int sum = 0;
        for(int i = 0; i <= 9; i++){
            sum = (sum + dfs(pres, memo, N-1, i)) % kMod;
            // System.out.println(sum);
        }
        return sum;
    }
    
    public int dfs(int[][] pres, int[][] memo, int cur, int i){
        // if(cur < 0) return 0;
        if(cur == 0) return 1;
        if(memo[cur][i] != 0) return memo[cur][i];
        
        int sum = 0;
        for(int pre : pres[i]){
            sum = (sum + dfs(pres, memo, cur-1, pre)) % kMod;
        }
        memo[cur][i] = sum;
        return sum;
    }