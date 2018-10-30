    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int start=0, max=0;
        for(int i = 0; i < ch.length; i++){
            if(!set.add(ch[i]) && s.indexOf(ch[i], start) != i){
                start = s.indexOf(ch[i], start)+1;
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }