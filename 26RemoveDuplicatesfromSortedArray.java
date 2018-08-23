    public int removeDuplicates(int[] nums) {
        
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            //出了些小错误，不知道 nums[i++]和把i++放到while{}里写有什么区别
            while(i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
            nums[j] = nums[i];
            j += 1;
        }
        return j;
    }