   public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length;
        if(min == 0) return 0;
        boolean sum = false;
        
        //两指针法，需注意的是如果所有和加起来都不足s，那么需要返回零，所以我加了个boolean变量
        int cur = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            cur += nums[i];
            while(left < i && (cur-nums[left]) >= s){
                cur -= nums[left];
                left++;
            }
            if(cur >= s){
                min = Math.min(min, i-left+1);
                sum = true;
            }   
        }
        return (sum) ? min : 0;
    }