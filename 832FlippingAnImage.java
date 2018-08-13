    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length, col = A[0].length;
        if(row == 0 || col == 0) return A;
        
        //这道题用binary operation会比较好哦，0与1的转换，0^1 = 1, 1^1 = 0
        //不用考虑col的奇偶性，因为A[i][col-1-j]始终等于tmp
        for(int i = 0; i < row; i++){
            for(int j = 0; j < (col+1)/2; j++){
                int tmp = A[i][j] ^ 1;
                A[i][j] = A[i][col-1-j] ^ 1;
                A[i][col-1-j] = tmp;

            }            
        }
        return A;
    }