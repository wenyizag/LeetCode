     public void sortColors(int[] nums) {
	        int start = 0, end = nums.length - 1;
	        	for(int i = 0; i < nums.length; i++) {
	        		while(nums[i] == 2 && end > i) swap(nums, i, end--);
                    //一定要先检查2，再检查0，否则就是WA，这是因为假如nums[i]=2, nums[end]=0，swap了一个0过来，
                    //变成nums[i]=0，这个时候0的位置就不对，还得继续换。
                    //但如果是先换0，因为前面的0已经是排好位置了，不可能换个2过来，就不用再检查。
	        		while(nums[i] == 0 && start < i) swap(nums, i, start++);
                    
	        	}
	 }
	 public void swap(int[] nums, int i, int j) {
		 int temp = nums[i];
		 nums[i] = nums[j];
		 nums[j] = temp;
	 }