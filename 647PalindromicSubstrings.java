    int ans = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            isPalindromic(s, i, i);
            isPalindromic(s, i, i+1);
        }
        return ans;
    }
    public void isPalindromic(String s, int left, int right){
        int l = left, r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            ans++;
        }
    }