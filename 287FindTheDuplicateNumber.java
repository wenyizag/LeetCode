    
//Solution 1
    public int findDuplicate(int[] nums) {
        //按照国际惯例，寻找duplicate的时候可以用正负值法，参考442和448
        for(int i = 0; i < nums.length; i++){
            int x = Math.abs(nums[i]);
            //该方法唯一要注意的是该返回Math.abs(nums[i]),因为该值可能之前被负数了
            if(nums[x] < 0) return Math.abs(nums[i]);
            nums[x] = -nums[x];
        }
        return 0;
    }

//Solution 2
//这个方法参考142， floyd's hare and tortoise算法，其实是个数学思路，之前的博客里有些
    public static int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);
        
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }