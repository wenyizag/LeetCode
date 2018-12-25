   //solution 1
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[N+1][m][n];
        int[] dir = {-1, 0, 1, 0, -1};
        int kMod = (int)(1e9 + 7);
        
        for(int c = 1; c <= N; c++){
            for(int a = 0; a < m; a++){
                for(int b = 0; b < n; b++){
                    for(int d = 0; d < 4; d++){
                        int x = a + dir[d];
                        int y = b + dir[d+1];
                        //这个数组没有初始化，都是0，只有超过边界的时候才会加1
                        if(x < 0 || y < 0 || x >= m || y >= n)
                            dp[c][a][b] +=1;
                        else
                            dp[c][a][b] = (dp[c][a][b] + dp[c-1][x][y]) % kMod;
                    }
                }
            }
        }
        
        return dp[N][i][j];
        
    }


    //solution 2. 压缩空间
        public int findPaths(int m, int n, int N, int i, int j) {
        int[][] dp = new int[m][n];
        int[] dir = {-1, 0, 1, 0, -1};
        int kMod = (int)(1e9 + 7);
        
        for(int c = 1; c <= N; c++){
            int[][] tmp = new int[m][n];
            for(int a = 0; a < m; a++){
                for(int b = 0; b < n; b++){
                    for(int d = 0; d < 4; d++){
                        int x = a + dir[d];
                        int y = b + dir[d+1];
                        //这个数组没有初始化，都是0，只有超过边界的时候才会加1
                        if(x < 0 || y < 0 || x >= m || y >= n)
                            tmp[a][b] +=1;
                        else
                            tmp[a][b] = (tmp[a][b] + dp[x][y]) % kMod;
                    }
                }
            }
            dp = tmp;
        }
        
        return dp[i][j];
        
    }