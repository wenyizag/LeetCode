//solution 1.计划递归
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<String, Boolean> mem = new HashMap<>();
        return word(s, dict, mem);
    }
    
    public boolean word(String s, HashSet<String> dict, HashMap<String, Boolean>mem) {
        if(dict.contains(s)) return true;
        if(mem.containsKey(s)) return mem.get(s);
        
        for(int i = 1; i < s.length(); i++) {
            if(word(s.substring(0, i), dict, mem) && dict.contains(s.substring(i))) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }
}


//solution 2
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length() + 1];
        //代表“”空串
        f[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(f[j] && set.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}