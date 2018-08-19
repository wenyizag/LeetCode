    public int maxSubArray(int[] nums) {
        int sum = nums[0], cur = nums[0];
        //把nums[i]的正负和和cur subarray的正负讨论一下
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0 && cur < 0){
                cur = Math.max(nums[i], cur);
            }else if(cur < 0){
                cur = nums[i];
            }else{
                cur += nums[i];
            }
            if(cur > sum) sum = cur;
        }
        return sum;
    }