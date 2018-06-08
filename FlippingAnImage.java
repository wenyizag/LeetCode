package leetcode;

public class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int tmp = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < (col+1)/2; j++) {
				tmp = A[i][j] ^ 1;
				A[i][j] = A[i][col-j-1] ^ 1;
				A[i][col-j-1] = tmp;
			}
		}
		return A;     
    }
}
