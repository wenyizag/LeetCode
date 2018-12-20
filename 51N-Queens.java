    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] cur : board) Arrays.fill(cur, '.');
        //0-row, 1-col, 2-decline 3-incline
        boolean[][] visited = new boolean[4][2*n];
        List<List<String>> ans = new ArrayList<>();
        DFS(board, ans, visited, n, 0);
        return ans;
    }
    
    private void DFS(char[][] board, List<List<String>> ans, boolean[][] visited,
                     int n, int col) {
        if(col >= n){
            construct(board, ans);
            return;
        }
        
        for(int row = 0; row < n; row++) {
            if(!avaiable(visited, row, col, n)) continue;
            board[row][col] = 'Q';
            put(visited, row, col, n,true);
            DFS(board, ans, visited, n, col+1);
            board[row][col] = '.';
            put(visited, row, col, n, false);
        }
    }
    
    private boolean avaiable(boolean[][] visited, int row, int col, int n) {
        return !visited[0][row] && !visited[1][col] 
            && !visited[2][row + col] && !visited[3][(n-1-row) + col];
    }
    
    private void put(boolean[][] visited, int row, int col, int n, boolean status) {
        visited[0][row] = status;
        visited[1][col] = status;
        visited[2][row + col] = status;
        visited[3][(n-1-row) + col] = status;
    }
    
    private void construct(char[][] board, List<List<String>> ans) {
        List<String> tmp = new ArrayList<>();
        for(char[] cur : board){
            tmp.add(String.valueOf(cur));
        }
        ans.add(tmp);
    }