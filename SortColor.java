     public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
         for(int i = 0; i <= right; i++){
             if(nums[i] == 0 && i != left){
                 swap(nums, i, left);
                 left++;
                 i--;
             }else if(nums[i] == 2 && i != right){
                 swap(nums, i, right);
                 right--;
                 i--;
             }
         }
     }
     public void swap(int[] nums, int i, int j){
         int tmp = nums[i];
         nums[i] = nums[j];
         nums[j] = tmp;
     }
