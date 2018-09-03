    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 4) return ans;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-3; i++){
            //每一步都要除重
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1, high = nums.length-1;
                while(low < high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        //这里为了防止溢栈需要把index限制一下
                        while(low < nums.length-1 && nums[low+1] == nums[low]) low++;
                        while(high > low && nums[high-1] == nums[high]) high--;
                        low++;
                        high--;
                    }else if(sum < target){
                        low++;
                    }else if(sum > target){
                        high--;
                    }
                }
                
            }
        }
        return ans;
    }