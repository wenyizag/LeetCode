    
    //先找到数组的最大值和最小值，然后以此作为二叉搜索的左右两边，求出其中间值，然后看比该值小的有多少个，是否满足条件，如果满足条件就返回，不然就将左右边界修改为mid即可。
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int low = matrix[0][0], high = matrix[row-1][col-1], mid = 0;
        
        while(low < high){
            mid = low + (high-low)/2;
            int count = 0, j = 0;
            for(int i = 0; i < row; i++){
                j = 0;
                while(j < row && matrix[i][j] <= mid) j++;
                count += j;
            }

            if(count < k) low = mid+1;
            else high = mid;
        }
       return low; 
    }