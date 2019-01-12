class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
            else if(i == max) {
                ans += 1;
                max = i + 1;
            }
        }
        return ans;
    }
}