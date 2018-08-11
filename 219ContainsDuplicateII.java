//Solution 1. HashMap

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int dis = i - map.get(nums[i]);
                if(dis <= k) return true;
                
            }
            //注意map的函数是put不是add。。
            map.put(nums[i], i);
        }
        return false;
    }

 //Solution 2. Slide Window && Set
     public boolean containsNearbyDuplicate(int[] nums, int k) {
        //这个是滑动窗口法
        if(nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }