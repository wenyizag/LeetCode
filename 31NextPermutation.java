    public static void nextPermutation(int[] nums) {
        //答案的动图特别生动形象，首先是理解permutation的意义，比如随便一个数{7, 8, 6, 4, 0, 2, 1}
        //我们看做数7864021，那它的next permutation的意思就是把这些数重组，下一个数比它大但是又尽可能的靠近它
        //所以7864021 -> 7864102
        //算法:
        //从左往右找降序，1-2是升序，2-0变成降序，那么0就是我们该替换的数，在我们之前遍历过的数中找出比它大的...不想写了，就那样吧，看答案吧
    		int len = nums.length;
    		int index = len-1;
    		while(index > 0 && nums[index] <= nums[index-1]) {
    			index--;
    		}
        //这一这里再减一个
    		index--;
    		if(index >= 0) {
    			int j = len-1;
    			while(nums[index] >= nums[j]) j--;
    			swap(nums, index, j);
    		}
    		revert(nums, index+1);
    }
    public static void revert(int[] nums, int i) {
    		int j = nums.length - 1;
    		while(i < j) {
    			swap(nums, i, j);
    			j--; i++;
    		}
    }
    public static void swap(int[] nums, int i, int j) {
    		int tmp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = tmp;
    }