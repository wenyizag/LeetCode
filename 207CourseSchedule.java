class Solution {
    	public boolean canFinish(int numCourses, int[][] prerequisites) {   
         //这个图是一个arraylist数组
		 ArrayList<Integer>[] graph = new ArrayList[numCourses];
		 for(int i = 0; i < numCourses; i++) {
			 graph[i] = new ArrayList<>();
		 }
		 for(int i = 0; i < prerequisites.length; i++) {
			 graph[prerequisites[i][1]].add(prerequisites[i][0]);
		 }
		 int[] visited = new int[numCourses];
		 for(int i = 0; i < numCourses; i++) {
 			 if(visited[i] == 0 && !dfs(graph, visited, i)) 
                 return false;
		 }
		 return true;		 
	 }
	 public static boolean dfs(ArrayList<Integer>[] graph, int[] visited, int i){
		 if(visited[i] != 0) return visited[i] == 2;
         visited[i] = 1;
         
		 for(int cur : graph[i]) {
             if(!dfs(graph, visited, cur)) 
                 return false;
         }
         
		 visited[i] = 2;
		 return true;
	 }
}