class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        for(int num : nums) {
            max = Math.max(max, num);
            // min = Math.min(min, num);
        }
        int[] count = new int[max+1];
        for(int num : nums) {
            count[num]++;
        }
        int take = 0, skip = 0;
        for(int i = 0; i < count.length; i++) {
            int takei = skip + count[i] * i;
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}