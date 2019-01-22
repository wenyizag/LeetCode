class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while(n != 1) {
            int t = 0;
            while(n != 0) {
                t += (n % 10) * (n % 10);
                n /= 10;
            }
            n = t;
            if(!s.add(n)) return false;
        }
        return true;
    }
}