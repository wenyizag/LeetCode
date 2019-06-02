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
        costs[src] = 0;
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[src] = 0;
        

        while(!q.isEmpty()) {
            City cur = q.poll();
            //为什么要把检测写在外圈而不是for内部里
            //因为有可能有多条路径到达des，如果在for内部一检测到到达des就直接返回
            //将不是返回最小路径，必须要先放进priorityqueue里，由q排过序，才能确定是最短
            if(cur.step > K+1) continue;
            if(cur.node == dst) return cur.cost;            
            
            for(int i = 0; i < n; i++) {
                if(graph[cur.node][i] != 0){
                    int newCost = cur.cost + graph[cur.node][i];
                    int newStep = cur.step + 1;
                    
                    // if(newStep > K+1) continue;
                    // if(i == dst) return newCost;
                    // System.out.println("costs[i]"+costs[i]+"step[i]"+steps[i]);
                    // System.out.println("newCost"+newCost+"newStep"+newStep);
                    
                    if(newCost < costs[i]) {
                        q.add(new City(i, newStep, newCost));
                        costs[i] = newCost;
                        steps[i] = newStep;
                    }
                    else if(newStep < steps[i]) {
                        q.add(new City(i, newStep, newCost));
                        costs[i] = newCost;
                        steps[i] = newStep;
                    }
                        
                }
            }
        }
        return -1;
    }
}
