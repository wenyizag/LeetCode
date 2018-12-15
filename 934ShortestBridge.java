class Direction {
    int x;
    int y;
    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int shortestBridge(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        boolean[][] visited = new boolean[row][col];
        //这个found变量是为了在发现第一座岛后停止DFS第二座岛
        boolean found = false;
        Direction[] dirs = {new Direction(0,1), 
                            new Direction(0,-1), 
                            new Direction(1,0), 
                            new Direction(-1,0)};
        
        Queue<Direction> q = new LinkedList<>();
        
        //DFS to find the first island
        for(int i = 0; i < row; i++){
            if(found) break;
            for(int j = 0; j < col; j++){
                if(A[i][j] == 1){
                    DFS(A, visited, q, dirs, i, j);
                    found = true;
                    break;
                }   
                // break;
            }
        }
        
        int step = 0;
        //BFS to connect islands
        System.out.println(q.size());
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Direction cur = q.poll();
                for(Direction d: dirs){
                    int curRow = cur.x + d.x;
                    int curCol = cur.y + d.y;
                    if(curRow < 0 || curCol < 0 || curRow >= row || curCol >= col || visited[curRow][curCol]) continue;
                    visited[curRow][curCol] = true;
                    if(A[curRow][curCol] == 1) return step;
                    q.offer(new Direction(curRow, curCol));
                }
                
            }
            step++;
        }
        return step;
    }
    
    //DFS function
    public void DFS(int[][] A, boolean[][] visited, Queue<Direction> q, Direction[] dirs, int i, int j){
        int row = A.length;
        int col = A[0].length;
        
        if(i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || A[i][j] == 0) return;
       
        visited[i][j] = true;
        q.offer(new Direction(i,j));
        for(Direction cur: dirs){
            DFS(A, visited, q, dirs, i+cur.x, j+cur.y);
        }
            
    }
}