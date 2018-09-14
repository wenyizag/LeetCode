    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int max = 0, maxlen = 0;
        int left = -1, right = -1;
        //time: O(N), space:O(1)
        for(int i = 0; i < s.length(); i++){
            int oddlen = isPalindrome(s, i, i);
            int evenlen = isPalindrome(s, i, i+1);
            maxlen = Math.max(oddlen, evenlen);
            if(maxlen > max){
                left = i - (maxlen-1)/2;
                right = i + maxlen/2;  
                max = maxlen;
            }
        }
        return s.substring(left, right+1);
    }
    
    public int isPalindrome(String s, int left, int right){
        int l = left, r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

    //DP
        public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int max = 0;
        int left = 0, right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                //i-j<=2 这个条件就是默认 "aa" 和 "a" 这种是true，因为原本的dp[i][i]没有初始化是false
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (i-j<=2 || dp[i-1][j+1]);
                if( dp[i][j] == true && i-j+1 >= max){
                    max = i-j+1;
                    left = j; right = i;
                }
            }
        }
        return s.substring(left, right+1);
    }