class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glass = new double[100][100];
        glass[0][0] = poured;
        for(int i = 0; i <= query_row; i++){
            for(int j = 0; j <= i; j++){
                if(glass[i][j] > 1){
                    if(i+1 < 100) 
                        glass[i+1][j] += (glass[i][j] - 1)/2;
                    if(i+1 < 100 && j+1 < 100) 
                        glass[i+1][j+1] += (glass[i][j] - 1)/2;
                    glass[i][j] = 1;
                }
            }
        }
        return glass[query_row][query_glass];
    }
}