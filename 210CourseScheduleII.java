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