    public int[] productExceptSelf(int[] nums) {
        //方法就是左乘一遍，右乘一遍
        int[] ans = new int [nums.length];
        ans[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int right = 1;
        for(int i = nums.length-2; i >= 0; i--){
            right *= nums[i+1];
            ans[i] *= right;
        }
        return ans;
    }