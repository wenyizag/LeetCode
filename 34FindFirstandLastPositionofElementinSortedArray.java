    public int[] searchRange(int[] nums, int target) {
        //我的思路是使用binary search找出一个mid，然后向两边拓展
        //还有另一种更快速的方法，但是写法会麻烦些，
        //就是写两个binary search，一个专门搜左边届, 另一个专门搜右边界，左边界示例如下
        //if(nums[mid]==target && (mid==0 || (mid-1>=0 && nums[mid-1]<nums[mid]))){
        //       return mid;
        //   }else if(target <= nums[mid]){
        //       end = mid-1;
        //    }else if(target > nums[mid]){
        //        start = mid+1;
        //   }
        //return -1;
        
        int[] ans = {-1, -1};
        if(nums.length == 0) return ans;
        int low = 0, high = nums.length-1, mid = -1;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                break;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(nums[mid] != target){
            return ans;
        }
        int left = mid, right = mid;
        while(left > 0 && nums[left] == nums[left-1]) left--;
        while(right < nums.length-1 && nums[right] == nums[right+1]) right++;
        return new int[]{left, right};
        
    }