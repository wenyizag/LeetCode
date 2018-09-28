    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if(num == 0) return ans;
        for(int i = 1; i <= num; i++){
            ans[i] = ans[i>>1] + (i & 1);
            
        }
        return ans;
    }