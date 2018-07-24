	//Solution 1

	public int[][] updateMatrix(int[][] matrix) {    
	//方法还是BFS，遍历两次
	//第一次将所有的0加入q中，将所有的1改为MAX_VALUE
	//第二次就是将0poll出来，如果周围有值因此而变小，那么也将这个值加入到q中
	Queue<Coordinate> q = new LinkedList<Coordinate>();
	int[] deltaX = {0, 1, 0, -1};
	int[] deltaY = {1, 0, -1, 0};
	
	int row = matrix.length;
	int col = matrix[0].length;
    boolean hasone = false;
	for(int i = 0; i < row; i++) {
		for(int j = 0; j < col; j++) {
			if(matrix[i][j] == 0) {
				q.add(new Coordinate(i, j));
			}else {
				matrix[i][j] = Integer.MAX_VALUE;
                hasone = true;
			}
		}
	}
	while(!q.isEmpty() && hasone) {
		Coordinate cur = q.poll();
		for(int i = 0; i < 4; i++) {
			int x = cur.x + deltaX[i];
			int y = cur.y + deltaY[i];
			//测试边界
			if(x < 0 || x >= row || y < 0 || y >= col || matrix[x][y] <= (matrix[cur.x][cur.y]+1))
				continue;
			else {
				//只有值变化了才加入q，不然就无限循环下去了
				matrix[x][y] = matrix[cur.x][cur.y]+1;
				q.add(new Coordinate(x, y));
			}
		}
	}
	return matrix;
    }


    //Solution 2

    	public int[][] updateMatrix(int[][] matrix) {    
	//这种解法的思路是DP，其实也很好理解，也是两边遍历matrix
	//第一遍从头到尾顺序遍历，遇到不是0的情况，就与左和上比较（因为左和上方向已经访问过）
	//第二遍时从尾到头遍历，遇到非零情况就与右和下比较
	//两遍遍历后就四个方向都更新了
	int row = matrix.length;
	int col = matrix[0].length;
	
	for(int i = 0; i < row; i++) {
		for(int j = 0; j < col; j++) {
			if(matrix[i][j] != 0) {
				//这里至关重要
				//要先改变matrix的值，改的值得是【max_value-1】，一定要减1，不然就WA
				//这是因为有可能左与上的值处于边界，仍是max_value，这个时候max_value+1就溢栈了
				matrix[i][j] = Integer.MAX_VALUE-1;
				//注意判断边界
				if(i > 0) matrix[i][j] = Math.min(matrix[i-1][j]+1, matrix[i][j]);
				if(j > 0) matrix[i][j] = Math.min(matrix[i][j-1]+1, matrix[i][j]);
			}
		}
	}	
	for(int i = row-1; i >= 0; i--) {
		for(int j = col-1; j >= 0; j--) {
			if(matrix[i][j] != 0) {
				if(i < row-1) matrix[i][j] = Math.min(matrix[i+1][j]+1, matrix[i][j]);
				if(j < col-1) matrix[i][j] = Math.min(matrix[i][j+1]+1, matrix[i][j]);
			}
		}
	}
	return matrix;
}