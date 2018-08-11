    public int findShortestSubArray(int[] nums) {
        //思路就是开了一个数组拿来记count，一个hashmap拿来记最左边的index
        
        //如果有储存空间限制，只能用一个hashmap的话，就map的value做成链接，key是degree，value[0]是最左index，value[1]是最右index
        int degree = 0, length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] count = new int[50000];
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            count[nums[i]]++;
            //degree的情况是，当当前count大于degree时，一定要更新length
            //当当前count==degree时，哪个距离短选哪个当length
            if(count[nums[i]] > degree){
                degree = count[nums[i]];
                length = i - map.get(nums[i]) + 1;
            }else if(count[nums[i]] == degree){
                length = Math.min(length, i - map.get(nums[i]) + 1);
            }
        }
        return length;
    }