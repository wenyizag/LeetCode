//solution 1 两指针    
public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        if(sum[0] >= s) return 1;
        

        int left = 0, ans = nums.length;
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
            if(sum[i] >= s){
                while(left < i && sum[i]-sum[left] >= s) left++;
                ans = Math.min(ans, i-left+1);
            }
        }
        return (sum[len-1] >= s) ? ans : 0;

    }

//solution 2
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        // pre sum
        int[] preSum = new int[len+1];
        for(int i = 0; i < len; i++) {
            preSum[i+1] = preSum[i] + nums[i];
            if(nums[i] >= s) return 1;
        }
        
        if(preSum[len] < s) return 0;
        int ans = len;
        for(int i = len-1; i >= 0 && preSum[i+1] >= s; i--){
            int high = i, low = 0, mid, target = preSum[i+1]-s;
            while(high > low){
                mid = low + (high-low)/2;
                // System.out.println("high "+high+" low "+low+" mid "+mid);
                if(preSum[mid] <= target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            ans = Math.min(ans, i-low+2);
        }
        return ans;
    }
