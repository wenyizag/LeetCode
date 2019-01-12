class Solution {
    class City{
        int node;
        int step;
        int cost;
        public City(int node, int step, int cost){
            this.node = node;
            this.step = step;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for(int[] c : flights) {
            graph[c[0]][c[1]] = c[2];
        }
        PriorityQueue<City> q = new PriorityQueue<>(new Comparator<City>() {
            public int compare(City a, City b) {
                return a.cost - b.cost;
            }
        });
        q.add(new City(src, 0, 0));
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        // costs[src] = 0;
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[src] = 0;
        
        
        while(!q.isEmpty()) {
            City cur = q.poll();
            if(cur.node == dst) return cur.cost;
            else if(cur.step > K) continue;
            
            
            for(int i = 0; i < n; i++) {
                if(graph[cur.node][i] != 0){
                    int newCost = cur.cost + graph[cur.node][i];
                    int newStep = cur.step + 1;
                    if(newCost < costs[i]) {
                        q.add(new City(i, newStep, newCost));
                    }
                        
                }
            }
        }
        return -1;
    }
}