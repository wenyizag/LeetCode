//solution 1
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       int res = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                res = (res << 1) + 1;
            }else{
                res = (res << 1);
            }
            n = n >> 1;
        }
        return res;
    }
}


//solution 2
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       int res = 0;
        for(int i = 0; i < 32; i++) {
            res |= ((n >> i) & 1) << (31 - i);
        }
        return res;
    }
}