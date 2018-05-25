package leetcode;

public class uniquePath {
	//DP
	public static int uniquePaths(int m, int n) {
	       int[][] path = new int[m][n];
	       
	       for(int i = 0; i < m; i++) {
	    	   		for(int j = 0; j < n; j++) {
	    	   			if(i == 0 || j == 0) path[i][j] = 1;
	    	   			else path[i][j] = path[i-1][j] + path[i][j-1];
	    	   		}
	       }
	       
	       return path[m-1][n-1];
	}
	
	//space optimization
	public static int uniquePaths2(int m, int n) {
	       int[] path = new int[n];
	       path[0] = 1;
	       
	       for(int i = 0; i < m; i++) {
	    	   		for(int j = 1; j < n; j++) {
	    	   		    path[j] = path[j-1] + path[j];
	    	   		}
	       }
	       
	       return path[n-1];
	    }
	
	//Bit
	public static double uniquePaths3(int m, int n) {
	       double result = 1;
	       for(int i = 0; i < (m-1); i++) {
	    	   		result = result * (m+n-2-i) / (m-1-i);
	       }
	       return Math.round(result);
	}
}
