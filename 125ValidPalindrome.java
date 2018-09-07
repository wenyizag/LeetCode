    public boolean isPalindrome(String s) {
        //感觉这个题考了个正则表达式吧，注意replaceAll和正则表达式怎么写。或者还有个函数是isLetterOrDigit()，如果不是就跳过，这个更快
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        for(int i = 0, j = s.length()-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }