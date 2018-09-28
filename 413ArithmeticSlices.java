    public int numberOfArithmeticSlices(int[] A) {
        if(A.length <= 2) return 0;
        int diff = A[1]-A[0], ans = 0, len = 1;
        //用的数学方法，思路是每次连续的相同的差的最大长度，为len，比如{1，2，3，4}，len=3，那么len=3这样的长度中挑subarry = n*(n-1)/2;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == diff){
                len++;
            }else{
                diff = A[i] - A[i-1];
                if(len >= 2) ans += len*(len-1)/2;
                len = 1;
            }
        }
        if(len >= 2) ans += len*(len-1)/2;
        return ans;
    }

    //Dp方法
        public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int ans = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }