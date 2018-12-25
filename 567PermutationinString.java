    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];

        int len = s1.length();
        for(int i = 0; i < len; i++) 
            count[s1.charAt(i) - 'a']++;
        
        for(int i = 0; i < s2.length(); i++) {
            if(i >= len){
                count[s2.charAt(i-len)-'a']++;
            }
            count[s2.charAt(i)-'a']--;
            if(allZero(count)) return true; 
        }
        
        return false;
    }
    
    public boolean allZero(int[] count) {
        for(int cur: count){
            if(cur != 0) return false;
        }
        return true;
    }