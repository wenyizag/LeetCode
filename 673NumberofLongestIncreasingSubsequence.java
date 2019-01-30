class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        
        int[] lens = new int[len];
        int[] count = new int[len];
        Arrays.fill(count, 1);
        Arrays.fill(lens, 1);
        
        int ans = 1, max = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(lens[i] == lens[j] + 1) {
                        count[i] += count[j];
                    }else if(lens[i] <= lens[j]) {
                        lens[i] = lens[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            // System.out.println(lens[i] + " "  + count[i]);
            if(lens[i] > max) {
                max = lens[i];
                ans = count[i];
            }else if(lens[i] == max) {
                ans += count[i];
            }
            // ans = Math.max(ans, count[i]);
        }
        
        
        return ans;
    }
}