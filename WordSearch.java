	public static boolean[][] visited;
	public static boolean exist(char[][] board, String word) {
        //为什么要用两个for循环呢，因为没有规定始发点，不是非要从（0，0）出发
        for(int i = 0; i < board.length; i++) {
        		for(int j = 0; j < board[0].length; j++) {
        			visited = new boolean[board.length][board[0].length];
        			if(helper(board, word, visited, 0, i, j)) return true;
        		}
        }
        return false;
    }
    public static boolean helper(char[][] board, String word, boolean[][] visited, 
    		int index, int i,int j) {
    		if(index >= word.length()) return true;
    		if(i<0 || i >= board.length || j<0 || j>=board[0].length || visited[i][j] || 
    			board[i][j] != word.charAt(index)) return false;
    		visited[i][j] = true;
    		boolean exist = helper(board, word, visited, index+1, i, j+1)||
    			   helper(board, word, visited, index+1, i, j-1)||
    			   helper(board, word, visited, index+1, i+1, j)||
    			   helper(board, word, visited, index+1, i-1, j);
            //为什么这里要把visited重新归为false呢，因为这个时候跳出了递归，表示此路通或不通，
            //如果不通，就相当于没有访问过，因为题目的要求只是计算过的点不能重新计算，举个例子：
            //char[][] a = {
				//{'A','B','C','E'},
				//{'S','F','E','S'},
				//{'A','D','E','E'}
				//};
		    //String b = "ABCESEEEFS";
            //这个时候第二排的S左和下都有E，都可以走，如果先走的左边的E，不通，被设为了true，想要重新走下边的E的时候，应该
            //把左边的E访问清除。
            
    		visited[i][j] = false;
    		return exist;
    }