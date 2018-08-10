    public int threeSumClosest(int[] nums, int target) {
     	Arrays.sort(nums);
        //这里之前我是用的 Integer.MAX_VALUE，但是错了，因为Math.abs(MAX-target)溢出了
        int ans = nums[0]+nums[1]+nums[2];
        
        //这道题就是3sum的变形
        int low, high, tmp;
        for(int i = 0; i < nums.length-2; i++) {
    			if(i==0 || nums[i]!=nums[i-1]) {
    			    low = i+1;
                    high = nums.length-1;
                    while(low < high) {
                        tmp = nums[low] + nums[high] + nums[i];
                    		if(tmp == target) {
                    			return tmp;
                    		}
                    		if(Math.abs(tmp-target) < Math.abs(ans-target)) {
                				ans = tmp;
                			}
                    		if(tmp > target) {
                    			high--;
                    		}else{
                    			low++;
                    		}
                    }
    			}     
        }
        return ans; 
    }