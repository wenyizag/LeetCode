    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();


        int sum = 0;
        //这里的-1是指index，也就是预设最开始sum = 0
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i]; 
            if(k != 0) sum %= k;
            if(map.containsKey(sum)){
                if(i-map.get(sum) > 1) return true;  
            }else{
                map.put(sum, i);
            }
        }
        return false;
    }