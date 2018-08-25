//Solution 1. HashMap
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //为了方便简洁，sum的长度是n+1
        int[] sum = new int[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        //这里非常重要哦，为什么要把0也放进去呢，是为了之后sum[i]直接等于k的时候，sum[i] - 0 = k
        map.put(0, 1);
        for(int i = 1; i <= nums.length; i++){
            //求出当前sum
            sum[i] = sum[i-1] + nums[i-1]; 
            //查看map里是否含有sum[i] - sum[j] == k，而sum[j]可以等于0，也就是sum[i]直接等于k
            if(map.containsKey(sum[i] - k)){
                count += map.get(sum[i] - k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0)+1);
        }
        
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];  
        }
        
//这种就是没有用到HashMap，一个一个去找，比较耗时，O(nlgn)
        for(int i = 0; i < nums.length; i++){
            if(sum[i] == k) count++;
            for(int j = 0; j < i; j++){
                if(sum[i] - sum[j] == k) count++;
            }
        }
        return count;
    }