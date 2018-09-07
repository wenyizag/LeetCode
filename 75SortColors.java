     public void sortColors(int[] nums) {
         int left = 0, right = nums.length-1;
         //这里为什么是 <= right呢，为什么要加个等号呢，比如例子{2，0，1}，
         //通过第一次置换后变{1，0，2}，此时right=1，i=1，left=0，right和i相等，但是left没有被检查到啊
         for(int i = 0; i <= right; i++){
             while(nums[i] == 2 && i < right){
                 swap(nums, i, right);
                 right--;
             }
             while(nums[i] == 0 && left < i){
                 swap(nums, i, left);
                 left++;
             }
         }
     }
     public void swap(int[] nums, int i, int j){
         int tmp = nums[i];
         nums[i] = nums[j];
         nums[j] = tmp;
     }