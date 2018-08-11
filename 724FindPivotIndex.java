    public int pivotIndex(int[] nums) {
        //唯一需注意的是边界问题，它的pivot可能在0，也可能在nums.length，只要余下部分的合为0
        if(nums.length == 0) return -1;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        int presum = 0;
        for(int i = 0; i < nums.length; i++){
            if(presum == (sum-presum-nums[i])) return i;
            presum += nums[i];
        }
        return -1;
    }