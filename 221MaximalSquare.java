  public int maximalSquare(char[][] matrix) {
      
        //这道题还是一个DP，有一个中文版的解释非常详细，我就不多说了:
       // http://www.cnblogs.com/thoupin/p/4780352.html
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
      
        int[][] s = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for(int i = 0; i < matrix.length; i++) {
        		s[i][0] = (matrix[i][0] == '1') ? 1 : 0;
        		if(s[i][0] == 1) {
        			max = 1;
        		}
        }
        
        for(int i = 1; i < matrix[0].length; i++) {
    			s[0][i] = (matrix[0][i] == '1') ? 1 : 0;
    			if(s[0][i] == 1) {
        			max = 1;
        		}
        }
        
        for(int i = 1; i < matrix.length; i++) {
        		for(int j = 1; j < matrix[0].length; j++) {
        			if(matrix[i][j] == '1') {
        				int left = s[i-1][j];
            			int top = s[i][j-1];
            			int left_top = s[i-1][j-1];
            			s[i][j] = Math.min(Math.min(left, top),left_top) + 1;
            			
            			if(s[i][j] > max) max = s[i][j];
        			}	
        		}
        }
        
        return max * max;
    }