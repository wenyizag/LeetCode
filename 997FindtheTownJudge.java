    public int findJudge(int N, int[][] trust) {
        int[] degrees = new int[N+1];
        
        for(int[] cur : trust) {
            degrees[cur[0]]--;
            degrees[cur[1]]++;
        }
        
        for(int i = 1; i <= N; i++) {
            if(degrees[i] == N-1) return i;
        }
        return -1;
    }