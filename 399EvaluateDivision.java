class Solution {
    class Pair {
        String s;
        Double v;
        public Pair(String s, Double v) {
            this.s = s;
            this.v = v;
        }
    }
    public HashMap<String, LinkedList<Pair>> graph;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
         graph = new HashMap<>();
        generateGraph(equations, values);
        
        double[] ans = new double[queries.length];
        int index = 0;
        // Set<String> visited = new HashSet<>();
        for(String[] cur : queries) {
            Double tmp = DFS(cur[0], cur[1], new HashSet<>());
            ans[index++] = (tmp != null) ? tmp : -1.0;
        }
        
        return ans;
        
    }
    
    public Double DFS(String first, String target, Set<String> visited) {
        if(!graph.containsKey(first) || !graph.containsKey(target) ||
           visited.contains(first)) return null;
        if(first.equals(target)) return 1.0;
        
        visited.add(first);
        for(Pair cur : graph.get(first)) {
            if(!visited.contains(cur.s)) {
                Double ans = DFS(cur.s, target, visited);
                if(ans != null) return cur.v * ans;
            }
        }
        visited.remove(first);
        return null;  
    }
    
    public void generateGraph(String[][] equations, double[] values) {
        for(int i = 0; i < values.length; i++) {
            String first = equations[i][0]; 
            String second = equations[i][1]; 
            if(!graph.containsKey(first))
                graph.put(first, new LinkedList<>());
            if(!graph.containsKey(second))
                graph.put(second, new LinkedList<>());
            graph.get(first).add(new Pair(second, values[i]));
            graph.get(second).add(new Pair(first, 1/values[i]));
        }
    }
}