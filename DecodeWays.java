package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return dp(s, 0);
    }
    
    HashMap<Integer, Integer> map = new HashMap<>();
    public int dp(String s, int start){
        if(start > s.length()-1) return 1;
        if(s.charAt(start) == '0') return 0;
        if(start == s.length()-1) return 1;
        
        if(map.containsKey(start)) return map.get(start);
        
        int sum = dp(s, start+1);
        int two = (s.charAt(start)-'0')*10 + (s.charAt(start+1)-'0');
        if(two <= 26) sum += dp(s, start+2);
        map.put(start, sum);
        return sum;
    }
