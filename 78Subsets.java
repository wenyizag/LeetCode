    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        helper(0, nums, new ArrayList<Integer>(), ans);
        return ans;
    }
	
	public void helper(int start, int[] nums, ArrayList<Integer> list, List<List<Integer>> ans){
		ans.add(new ArrayList<Integer>(list));
		for(int i = start; i < nums.length; i++) {
    			list.add(nums[i]);
            //注意这里加的是i+1, 不是start+1...
    			helper(i+1, nums, list, ans);
    			list.remove(list.size()-1);
    	}

        return;
	}