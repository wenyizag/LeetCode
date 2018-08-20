    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(row == 0 || col == 0) return 0;
        
        //典型的dp，只用一维是为了节省空间
        int[] dp = new int[col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0){
                    dp[j] = grid[i][j];
                }else if(i == 0){
                    dp[j] = dp[j-1] + grid[i][j];
                }else if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[col-1];
    }