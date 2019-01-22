//solution 1
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for(int num : nums) sum += num;
        return (n+1) * n / 2 - sum;
    }
}

//solution 2
class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans ^= (i+1) ^ nums[i];
        }
        return ans;
    }
}