 public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        
        int col = matrix[0].length-1, row = 0;
        
        //从右上角开始, 比较target 和 matrix[i][j]的值. 
        //如果小于target, 则该行不可能有此数,  所以i++; 
        //如果大于target, 则该列不可能有此数, 所以j--. 
        //遇到边界则表明该矩阵不含target.
        while(col >= 0 && row < matrix.length){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }