    public List<List<Integer>> threeSum(int[] nums) {
	    Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int low, high, tmp;
        for(int i = 0; i < nums.length-2; i++) {
            //注意对于nums[i]来说，要先do，再排重，比如[-1,-1, 2]这样的组合
    			//不能一下子就把nums[i]的重复值都跳过，因为两个重复的可能是答案
    			if(i==0 || nums[i]!=nums[i-1]) {
    			    low = i+1;
                    high = nums.length-1;
                    while(low < high) {
                        tmp = -(nums[low] + nums[high]);
                        if(tmp == nums[i]) {
                             ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                             while(low < high && nums[low] == nums[low+1] ) low++;
                             while(low < high && nums[high] == nums[high-1]) high--;  
                             low++;
                             high--;   
                        }else if(tmp < nums[i]) {
                        	//注意这tmp和nums[i]的关系，因为是tmp与-nums[i]比，所以小的时候该减
                        	//大的时候反而该增
                            high--;
                        }else {
                        	low++;
                        }
                    }
    			}     
        }
        return ans; 
    }