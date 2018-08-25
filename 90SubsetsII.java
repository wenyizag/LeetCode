    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //两个要点，第一是要sort array, 不然像数组{4,4,4,1,4}，如果不sort{4，1，4}这样的subset就会被重复添加，
        //nums[i] == nums[i+1]根本起不到作用
        Arrays.sort(nums);
        helper(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    
    public void helper(int[] nums, int start, 
    		List<List<Integer>> ans, List<Integer> list) {
    		ans.add(new ArrayList<Integer>(list));
    		for(int i = start; i < nums.length; i++) {
    			list.add(nums[i]);
    			helper(nums, i+1, ans, list);
    			list.remove(list.size()-1);
                //第二个是在backtracking后进行除重
                while(i<nums.length-1 && nums[i] == nums[i+1]) i++;  
    		}
    		return;
    }