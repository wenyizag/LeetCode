    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // if(nums.length == 0) return ans;
        int left = first(nums, target, true);
        if(left == nums.length || nums[left] != target) return ans;
        ans[0] = left;
        ans[1] = first(nums, target, false)-1;
        return ans;
        
    }
    public int first(int[] nums, int target, boolean first){
        int low = 0, high = nums.length, mid;
        while(low < high){
            mid = low + (high-low)/2;
            if(nums[mid] > target || (first && nums[mid] == target)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
