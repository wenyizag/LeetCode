   
//Solution 1. Binary Search, Time Complexity O(nlogn)
    public int lengthOfLIS(int[] nums) {
        // write your code here
        //讲一下这个tails存的是什么，其实tails[i]存的就是长度为i+1的升序subarray的最后一个。
        //具体查看solution
        if(nums.length == 0){
            return 0;
        }
        int len = 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            } else if (nums[i] > tails[len]){
                tails[++len] = nums[i];
            } else {
            // 如果在中间，则二分搜索
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }
    
    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }

//Solution 2. 自己想的
 public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            int max = 1;
            int[] count = new int[nums.length];
            Arrays.fill(count, 1);
            
            for(int i = 1; i < nums.length; i++) {
                int cur = 1;
                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        count[i] = Math.max(count[i], count[j] + 1);
                    }
                }
                //System.out.println(count[i]);
                if(count[i] > max) max = count[i];
            }
            return max;
    }