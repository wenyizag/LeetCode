class Solution {
    public int reachNumber(int target) {
        int step = 1, sum = 1;
        target = Math.abs(target);
        while(sum < target) {
            sum += ++step;
        }
        while((sum - target) % 2 != 0){
            sum += ++step;
        }
        return step;
        
    }
}