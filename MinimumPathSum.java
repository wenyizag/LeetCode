public static int minPathSum(int[][] grid) {
	if(grid.length == 0 || grid[0].length == 0) return 0;
	int[] sum = new int[grid[0].length];
	
	for(int i = 0; i < grid.length; i++) {
		for(int j = 0; j < grid[0].length; j++) {
			if(i == 0 && j == 0) sum[j] = grid[i][j];
			else if(i == 0) sum[j] = sum[j-1] + grid[i][j];
			else if(j == 0) sum[j] = sum[j] + grid[i][j];
			else sum[j] = Math.min(sum[j-1], sum[j]) + grid[i][j];
		}
	}
	
	return sum[grid[0].length-1];
    
}