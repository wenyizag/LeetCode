    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i = 1; i < nums.length; i++){
            //这个if条件写得挺耐人寻味的，满足了仅逆序时求最大和最小
            if(nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
        }
        
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i] > nums[i+1]){
                max = Math.max(max, nums[i]);
            }
        }
        
        if(min == Integer.MAX_VALUE) return 0;
                
        int left = 0, right = nums.length-1;      
        while(left < nums.length && nums[left] <= min) left++;
        while(right >= 0 && nums[right] >= max) right--;
        
        return right-left+1;
    }