    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            if(!map.containsKey(i) && !DFS(graph, i, map, true)) return false;
        }
        return true;
    }
    
    public boolean DFS(int[][] graph, int i, HashMap<Integer, Boolean> map, Boolean color) {
        map.put(i, color);
        for(int cur : graph[i]){
            if(map.containsKey(cur)){
                if(map.get(cur) == color) return false;
                //这里一直错错错，注意只要其中一个子集false, 就要返回false
            }else if(!DFS(graph, cur, map, !color)) return false;
        }
        return true;
    }


    //solution 2. map改成数组比较快
        public boolean isBipartite(int[][] graph) {
        int[] colors = new int[101];
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == 0 && !DFS(graph, i, colors, 1)) return false;
        }
        return true;
    }
    
    public boolean DFS(int[][] graph, int i, int[] colors, int color) {
        colors[i] = color;
        for(int cur : graph[i]){
            if(colors[cur] != 0){
                if(colors[cur] == color) return false;
                //这里一直错错错，注意只要其中一个子集false, 就要返回false
            }else if(!DFS(graph, cur, colors, -color)) return false;
        }
        return true;
    }

    //solution 3. BFS
        public boolean isBipartite(int[][] graph) {
        int[] colors = new int[101];
        
        for(int i = 0; i < graph.length; i++){
            if(graph[i].length != 0 && colors[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                
                while(!q.isEmpty()){
                    int cur = q.poll();
                    
                    for(int next : graph[cur]){
                        if(colors[next] != 0){
                            if(colors[next] == colors[cur]) return false;
                        }else{
                            colors[next] = -(colors[cur]);
                            q.add(next);
                        }
                    }
                }
            }
        }
        return true;
    }