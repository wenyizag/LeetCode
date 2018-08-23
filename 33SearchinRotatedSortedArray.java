    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]) return mid;
            
            //两种pivot分开讨论
            if(nums[low] <= nums[mid]){
                //只有一边是升序，另一边仍然含有pivot，与升序的那边比较
                if(target < nums[mid] && target >= nums[low])
                    high = mid-1;
                //否之则是含有pivot的那边
                else low = mid+1;
            }else{
                if(target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else high = mid-1;
            }
        }
        return -1; 
    }