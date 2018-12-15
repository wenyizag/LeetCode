class Solution {
    public boolean hasAlternatingBits(int n) {
        int b = n & 1;
        while((n & 1) == b){
            b ^= 1;
            n >>= 1;
        }
        return n == 0;
    }
}