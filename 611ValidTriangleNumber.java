class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int ans = 0;
        //这道题好像只能从大到小排序才能使用贪心。。
        for(int i = nums.length - 1; i >= 2; i--){
            int low = 0;
            int high = i - 1;
            while(low < high) {
                if((nums[low] + nums[high]) > nums[i]) {    
                    // System.out.println(i + " " + low + " " + high);
                    ans += high - low;
                    high--;
                }else {
                    low++; 
                }
            }
        }
        return ans;
    }
}