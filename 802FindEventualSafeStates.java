    /* state:
     0 - hasn't been visited
     1 - unsafe
     2 - safe
    */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(DFS(graph, visited, i))
               ans.add(i);
        }
        return ans;
    }
    
    private boolean DFS(int[][] graph, int[] visited, int i){
        if(visited[i] != 0) return visited[i] == 2;
        visited[i] = 1;
        for(int cur : graph[i]){
            if(!DFS(graph, visited, cur)) return false;
        }
        visited[i] = 2;
        return true;
    }