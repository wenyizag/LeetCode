class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = words[i];
            if(map.containsKey(c)) {
                if(!map.get(c).equals(s))
                    return false;
            }
            else if(map.containsValue(s)) return false;
            map.put(c, s);
        }
        return true;
    }
}