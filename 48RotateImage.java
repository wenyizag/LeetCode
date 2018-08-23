    public void rotate(int[][] matrix) {
        int col = matrix.length-1;
        
        for(int i = 0; i <= col/2; i++){
            //注意j的起始值和终结值
            for(int j = i; j < col-i; j++){
                //旋转的时候怎么判断坐标，画方位图，比如对于上侧（↓，→）的移动方向， 的对应的右侧是(←,↓)
                //由此右侧的row随着上侧的col的增大而增大，它的col随着上侧的row的增大而减小
                //所以如果上侧是(i,j)，则右侧是(j, len-i)
                //由于是个正方形，row和col相等，所以不作区分。
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[col-j][i];
                matrix[col-j][i] = matrix[col-i][col-j];
                matrix[col-i][col-j] = matrix[j][col-i];
                matrix[j][col-i] = tmp;
            }
        }    
    }