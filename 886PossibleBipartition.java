    public boolean possibleBipartition(int N, int[][] dislikes) {
        /* 
        1. create graph
        2. DFS all nodes
        */
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int[] cur : dislikes){
            int n1 = cur[0], n2 = cur[1];
            if(graph[n1] == null) graph[n1] = new ArrayList<>();
            if(graph[n2] == null) graph[n2] = new ArrayList<>();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        int[] colors = new int[N+1];
        for(int i = 1; i <= N; i++){
            if(colors[i] == 0 && !bipartition(graph, colors, i, 1))
                return false;
        }
        return true;
    }
    
    private boolean bipartition(ArrayList<Integer>[] graph, int[] colors, int i, int c){
        colors[i] = c;
        if(graph[i] == null) return true;
        for(int n : graph[i]){
            if(colors[n] == c) return false;
            else if(colors[n] == 0 && !bipartition(graph, colors, n, -c)) return false;
        }
        return true;
    }