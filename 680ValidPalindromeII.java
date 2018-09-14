    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j; i++,j--){
            if(s.charAt(i) != s.charAt(j)) return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
        }
        return true;
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            end--;
            start++;    
        }
        return true;
    }