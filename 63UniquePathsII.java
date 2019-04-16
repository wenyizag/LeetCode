class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0) return 0;
        int col = obstacleGrid[0].length;
        
        int[] dp = new int[col];
        
        for(int i = 0 ; i < row; i++) { 
            for(int j = 0; j < col; j++) {
                if(obstacleGrid[i][j] == 1) dp[j] = 0;
                else if(i == 0 && j == 0) dp[j] = 1;
                else if(i == 0) dp[j] = dp[j - 1];
                else if(j == 0) dp[j] = dp[j];
                else dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[col - 1];
    }
}