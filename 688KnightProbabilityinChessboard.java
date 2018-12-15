//solution 1. 逆序
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{2,1}, {2,-1}, {-2,1}, {-2,-1},
                        {1,2}, {1,-2}, {-1,2}, {-1,-2}};
        double[][][] memo = new double[K+1][N][N];
        return steps(N, K, dirs, memo, r, c);
    }
    public double steps(int N, int K, int[][] dirs, double[][][] memo, int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= N) return 0;
        if(K == 0) return 1;
        if(memo[K][r][c] != 0) return memo[K][r][c];
        double rate = 0;

        for(int[] dir: dirs){
            rate += 0.125 * steps(N, K-1, dirs, memo, r+dir[0], c+dir[1]);
        }
        memo[K][r][c] = rate;
        return rate;
    }


//Solution 2. 顺序
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{2,1}, {2,-1}, {-2,1}, {-2,-1},
                        {1,2}, {1,-2}, {-1,2}, {-1,-2}};
        //用int存储会溢栈，因为数太大了
        double[][] memo = new double[N][N];
        for(double[] cur : memo) Arrays.fill(cur, 1);
        
        for(int l = 0; l < K; l++){
            
            double[][] tmp = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int[] dir : dirs){
                        int curRow = i + dir[0];
                        int curCol = j + dir[1];
                        if(curRow < 0 || curCol < 0 || curRow >= N || curCol >= N) continue;
                        tmp[curRow][curCol] += memo[i][j];
                    }
                }
            }
            memo = tmp;
        }
        
        return memo[r][c] / Math.pow(8, K);
    }