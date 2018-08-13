public static boolean canJump(int[] nums) {
    //greedy
    int last = nums.length-1, i = 0, k = 0;
    
    while(i <= k){
        k = Math.max(k, i + nums[i]);
        if(k >= last) return true;
        i++;
    }
	return false;
}