    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] scores = new int[len][len];
        for(int[] cur: scores) Arrays.fill(cur, Integer.MIN_VALUE);
        
        DP(nums, scores, 0, len-1);
        return scores[0][len-1] >= 0;
    }
    public int DP(int[] nums, int[][] scores, int s, int e){
        if(s > e) return 0;
        if(s == e) {
            scores[s][e] = nums[s];
           return nums[s]; 
        }
        if(scores[s][e] != Integer.MIN_VALUE) return scores[s][e];
        
        scores[s][e] = Math.max(nums[s]-DP(nums, scores, s+1, e),
                               nums[e]-DP(nums, scores, s, e-1));
        return scores[s][e];
    }