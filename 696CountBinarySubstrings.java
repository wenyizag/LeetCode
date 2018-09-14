    public int countBinarySubstrings(String s) {
        //这里可以创建一个数组，数组元素存储每个连续子串的长度，例如，将字符串 1111000011010001011 转化为数组 [4, 4, 2, 1, 1, 3, 1, 1, 2]，根据这个数组，我们可以很方便地获得满足条件的子串个数，只需要将数组中相邻元素之间最小的那个求和即可
        
        //改进呢是不取数组，只用两个元素，pre和cur
        if(s.length() <= 1) return 0;

        int ans = 0;
        int cur = 1, pre = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) cur++;
            else{                
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 1;                
            }
        }
       ans += Math.min(pre, cur);

        return ans;
    }