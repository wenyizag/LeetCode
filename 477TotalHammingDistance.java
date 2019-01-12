class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            int count_1 = 0;
            for(int j = 0; j < nums.length; j++) {
                if((mask & nums[j]) == mask)
                    count_1++;
            }
            // System.out.println(count_1);
            mask <<= 1;
            ans += (nums.length - count_1) * count_1;
        }
        return ans;
    }
}