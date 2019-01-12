//Solution 1. DFS
class Solution {
     int index = 0;
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
		 //这个图是一个arraylist数组
		 ArrayList<Integer>[] graph = new ArrayList[numCourses];
         
		 for(int i = 0; i < numCourses; i++) {
			 graph[i] = new ArrayList<>();
		 }
		 for(int i = 0; i < prerequisites.length; i++) {
			 graph[prerequisites[i][1]].add(prerequisites[i][0]);
		 }
		 LinkedList<Integer> l = new LinkedList<>();
         int[] visited = new int[numCourses];
         for(int i = 0; i < numCourses; i++) {
             if(visited[i] == 0 && !dfs(graph, visited, i, l))
                 return new int[0];
         }
         int[] ans = new int[numCourses];
         for(int i = 0; i < numCourses; i++) {
             ans[i] = l.get(i);
         }
         
		 return ans;
		 		 
	 }
    
    public boolean dfs(ArrayList<Integer>[] graph, int[] visited, int i, LinkedList<Integer> l) {
        if(visited[i] != 0) return visited[i] == 2;
        visited[i] = 1;
        
        for(int cur : graph[i]) {
            if(!dfs(graph, visited, cur, l))
                return false;
        }
        //注意这里是加到头
        l.addFirst(i);
        visited[i] = 2;
        return true;
    }

}

//solution 2. BFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //top排序，思路是这样的
        //将courses看做节点，将pairs看做边，遍历所有pairs，将边记录到图中和degree中
        //如果degree==0，说明没有pre要求，将其加入queue中
        //q.poll的时候，将所有以当前节点作为pre的course的degree减一，当degree为0的时候
        //又可以加入queue中了
        int[] degree = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
                int cur = prerequisites[i][0];  
                int pre = prerequisites[i][1];
                graph[cur][pre] = 1;
                degree[cur]++; 
        }
        //记录已经加入的课的数量  
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
                if(degree[i] == 0) q.add(i);
        }
        
        int[] ans = new int[numCourses];
        while(!q.isEmpty()) {
                ans[count] = q.poll();
                for(int i = 0; i < numCourses; i++) {
                    if(graph[i][ans[count]] == 1) {
                        degree[i]--;
                        if(degree[i] == 0) {
                            q.add(i);
                        }
                    }
                } 
                count++;
        }
        return (count == numCourses) ? ans : new int[0];
    }
}