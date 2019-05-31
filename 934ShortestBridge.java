

class Solution {
    public int shortestBridge(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        int[] dirs = {0, 1, 0, -1, 0};
        //find the first island
        outerloop:
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(A[i][j] == 1) {
                    DFS(A, visited, q, row, col, i, j, dirs);
                    break outerloop;
                }
            }
        }

        int steps = 0;
        // System.out.println(q.size());
        //find the second island
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cur = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nextX = cur[0] + dirs[i];
                    int nextY = cur[1] + dirs[i+1];
                    if(nextX<0 || nextY<0 || nextX>=row || nextY>=col || visited[nextX][nextY]) continue;
                    visited[nextX][nextY] = true;
                    if(A[nextX][nextY] == 1) return steps;
                    else {
                        q.add(new int[]{nextX, nextY});
                    }
                }
            
            }
            steps++;
        }
        return -1;
    }
    
    //use DFS find the first island, and put its points into a queue
    public void DFS(int[][] A, boolean[][] visited, Queue<int[]> q, int row, int col, int x, int y, int[] dirs){
        //check for valid
        if(x<0 || y<0 || x>=row || y >=col || visited[x][y] || A[x][y] == 0) return;
        q.add(new int[]{x, y});
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            DFS(A, visited, q, row, col, x+dirs[i], y+dirs[i+1], dirs);
        }
    }
    
}
