//solution 1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] s_map = new int[128];
        int[] t_map = new int[128];
        for(int i = 0; i < t.length(); i++) {
            char cur_s = s.charAt(i);
            char cur_t = t.charAt(i);
            if(s_map[cur_s] != 0 && s_map[cur_s] != cur_t)
                return false;
            if(t_map[cur_t] != 0 && t_map[cur_t] != cur_s)
                return false;
            s_map[cur_s] = cur_t;
            t_map[cur_t] = cur_s;
        }
        return true;
    }
}


//solution 2
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] s_map = new int[128];
        int[] t_map = new int[128];
        for(int i = 0; i < t.length(); i++) {
            char cur_s = s.charAt(i);
            char cur_t = t.charAt(i);
            if(s_map[cur_s] != t_map[cur_t]) 
                return false;
            s_map[cur_s] = i + 1;
            t_map[cur_t] = i + 1;
        }
        return true;
    }
}