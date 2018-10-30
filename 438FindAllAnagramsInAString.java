    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        
        for(char cur : p.toCharArray()){
            map[cur-'a']++;
        }
        
        int start = 0, end = 0, len = p.length(), count = len;
        while(end < s.length()){
            if(map[s.charAt(end) - 'a']-- > 0) count--;
            if(count == 0) ans.add(start);
            end++;
            if(end - start == len){
                if(map[s.charAt(start) - 'a']++ >= 0) count++;
                start++;
            }
        }
        return ans;
    }