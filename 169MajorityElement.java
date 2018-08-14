    
//Solution 1
    public int majorityElement(int[] nums) {
       int candidate = nums[0], count = 0;
       
        for(int num : nums){
            if(count == 0) {
                candidate = num;
                count = 1;
            }
            else if(num != candidate) count--;
            else count++;
        }
        return candidate;
    }

//Solution 2
    public int majorityElement(int[] nums) {
        int half = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > half) return num;
        }
        
        return half;
    }