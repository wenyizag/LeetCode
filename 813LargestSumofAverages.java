class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] avg = new double[K][n];
        double[] sum = new double[n];
        
        sum[0] = A[0];
        avg[0][0] = A[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + A[i];
            avg[0][i] = sum[i] / (i+1);
        }
        
        for(int i = 1; i < K; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < j; k++){
                    //注意sum如果是int数组的话，(sum[j] - sum[k])/(j-k)将损失精度
                    avg[i][j] = Math.max(avg[i][j], avg[i-1][k] + (sum[j] - sum[k])/(j-k));
                }
            }
        }
        
        return avg[K-1][n-1];
    }
}