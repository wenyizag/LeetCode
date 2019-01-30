class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = (row > 0) ? matrix[0].length : 0;
        sum = new int[row+1][col+1];
        
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                sum[i][j] = matrix[i-1][j-1] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] + sum[row1][col1] - sum[row1][col2+1] - sum[row2+1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */