    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        
        if(points.length == 0) return 0;
        int ans = 1;
        int end = points[0][1];
        for(int cur = 1; cur < points.length; cur++){
            if(points[cur][0] > end){
                ans++;
                end = points[cur][1];
            }
        }
        return ans;
    }