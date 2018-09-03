    public int findMaxLength(int[] nums) {
        //思路是，用prefix sum记录0和1出现的情况，那么需要把0改为-1，这样-1+1=0
        //每当prefix重复出现的时候，说明这段subarray中间0和1个数相等
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int max = 0;
        //这里比较重要，是为了整个array0和1都相等的情况，为什么是-1不是0呢，因为比如{0, 1},它的prefix是{-1，0}，0的index是1，1-(-1)=2
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            prefix += (nums[i] == 1) ? 1 : -1;
            if(map.containsKey(prefix)){
                max = Math.max(max, i - map.get(prefix));
            }else{
                map.put(prefix, i);
            }
        }
        return max;
    }