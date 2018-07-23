//Solution 1 - BFS
    	public boolean canFinish(int numCourses, int[][] prerequisites) {   
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
        
        while(!q.isEmpty()) {
        		int pre = q.poll();
                count++;
        		for(int i = 0; i < numCourses; i++) {
        			if(graph[i][pre] == 1) {
        				degree[i]--;
        				if(degree[i] == 0) {
        					q.add(i);
        				}
        			}
        		}       		
        }
        return count==numCourses;
    }

//Solution 2 - DFS
public boolean canFinish(int numCourses, int[][] prerequisites) {   
         //这个图是一个arraylist数组
		 ArrayList[] graph = new ArrayList[numCourses];
		 for(int i = 0; i < numCourses; i++) {
			 graph[i] = new ArrayList();
		 }
		 for(int i = 0; i < prerequisites.length; i++) {
			 graph[prerequisites[i][0]].add(prerequisites[i][1]);
		 }
		 boolean[] visited = new boolean[numCourses];
		 for(int i = 0; i < numCourses; i++) {
			 if(!dfs(graph, visited, i)) return false;
		 }
		 return true;		 
	 }
	 public static boolean dfs(ArrayList[] graph, boolean[] visited, int course){
		 if(visited[course]){
			 return false;
		 }else {
			 visited[course] = true;
		 }
		 for(int i = 0; i < graph[course].size(); i++) {
			 //注意一个问题，因为这个dfs是有返回的，所以递归的时候要写成if句型，不能直接call
			 if(!dfs(graph, visited, (int)graph[course].get(i)))
				 return false;
		 }
		 //这个dfs的作用是拿来查看有环没环，我们在这里重新设置为false是因为，上面的主函数是用一个for
		 //去呼叫dfs，这种顺序肯定会重复访问到已经访问的课程，比如0的pre是1，那么我在dfs0的时候就访问了1
		 //之后for会再叫一次1
		 visited[course] = false;
		 return true;
	 }