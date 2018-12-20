    public int findCircleNum(int[][] M) {
        int num = M.length;
        boolean[] visited = new boolean[num];
        
        int circle = 0;
        for(int i = 0; i < num; i++){
            if(visited[i]) continue;
            circle++;
            DFS(M, visited, num, i);
        }
        return circle;
    }
    
    private void DFS(int[][] M, boolean[] visited, int num, int i){
        if(visited[i]) return;
        
        visited[i] = true;
        for(int j = 0; j < num; j++){
            if(M[i][j] != 0){
                DFS(M, visited, num, j);
            }
        }
    }