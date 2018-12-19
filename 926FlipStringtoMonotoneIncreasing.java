//Solution 1. dp (可以改良空间)
    public int minFlipsMonoIncr(String S) {
        char[] c = S.toCharArray();
        int len = c.length;
        int[][] dp = new int[len+1][2];
        
        for(int i = 0; i < len; i++) {
            if(c[i] == '0'){
                dp[i+1][0] = dp[i][0];
                dp[i+1][1] = Math.min(dp[i][0], dp[i][1]) + 1;
            }else{
                dp[i+1][0] = dp[i][0] + 1;
                dp[i+1][1] = Math.min(dp[i][0], dp[i][1]);
            }
        }
        
        return Math.min(dp[len][0], dp[len][1]);
    }


//Solution 2. 空间优化版
    public int minFlipsMonoIncr(String S) {
        char[] c = S.toCharArray();
        int len = c.length;
        int end0 = 0, end1 = 0;
        
        for(int i = 0; i < len; i++) {
            if(c[i] == '0'){
                end0 = end0;
                end1 = Math.min(end0, end1) + 1;
            }else{
                end1 = Math.min(end0, end1);
                end0 = end0 + 1;
            }
        }
        
        return Math.min(end0, end1);
    }


//solution 3. 左右遍历法，与那个城市下雨的题一样
    public int minFlipsMonoIncr(String S) {
        char[] c = S.toCharArray();
        int len = c.length;
        int[] left = new int[len+1];
        // int[] right = new int[len+1];
        
        for(int i = 0; i < len; i++){
            left[i+1] = (c[i] == '0') ? left[i] : left[i] + 1;
        }
        
        int ans = left[len], right = 0;
        for(int i = len-1; i >= 0; i--){
            ans = Math.min(ans, left[i] + right);
            right = (c[i] == '1') ? right : right + 1;
        }
        return ans;
    }