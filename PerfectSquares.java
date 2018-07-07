	public static int numSquares(int n) {
        int[] squares = new int[n+1];
        Arrays.fill(squares, Integer.MAX_VALUE);
        squares[0] = 0;
        
        //一个中规中矩的DP
        for(int i = 1; i <= n; i++) {
        		int min = Integer.MAX_VALUE;
        		int j = 1;
        		while(i - j*j >= 0) {
        			min = Math.min(min, squares[i-j*j]+1);
        			j++;
        		}
        		squares[i] = min;
        }
        return squares[n];
    }