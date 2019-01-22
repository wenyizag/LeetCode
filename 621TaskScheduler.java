class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        for(char cur : tasks) {
           max = Math.max(max, ++count[cur-'A']);
        }
        int remain = 0;
        for(int c : count) {
            if(c == max) 
                remain++;
        }
        
        return Math.max((max - 1) * (n + 1) + remain, tasks.length);
        
    }
}