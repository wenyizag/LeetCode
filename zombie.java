	public static int[] deltaX = {1, 0, 0, -1};
	public static int[] deltaY = {0, 1, -1, 0};
	
	public static int zombie(int[][] grid) {
		int people = 0, day = 0;
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) people++;
				else if(grid[i][j] == 2) {
					q.offer(new Coordinate(i,j));
				}
			}
		}

		if(people == 0) return 0;
		
		while(!q.isEmpty()) {
			day++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Coordinate cur = q.poll();
				for(int j = 0; j < 4; j++) {
					int x = cur.x + deltaX[j];
					int y = cur.y + deltaY[j];
					
					if(isPeople(grid, x, y)) {
						grid[x][y] = 2;
						people--;
						if(people == 0) return day;
						q.offer(new Coordinate(x,y));
					}
				}
			}
		}
		
		return -1;
	}
	
	public static boolean isPeople(int[][] grid, int x, int y) {
		if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] != 1)
			return false;
		else return true;
	}