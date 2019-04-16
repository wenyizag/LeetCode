//solution 1. 26个字母挨个变化
class MagicDictionary {

    /** Initialize your data structure here. */
    HashSet<String> map;
    public MagicDictionary() {
        map = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        map.addAll(Arrays.asList(dict));
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] c = word.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            char tmp = c[i];
            for(char j = 'a'; j <= 'z'; j++) {
                if(tmp == j) continue;
                c[i] = j;
                if(map.contains(String.valueOf(c))) return true;
                c[i] = tmp;
            }
        }
        return false;
    }
}

//solution 2. 模糊搜索
class MagicDictionary {

    /** Initialize your data structure here. */
    HashMap<String, List<Character>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict) {
            char[] c = s.toCharArray();
            for(int i = 0; i < c.length; i++) {
                char tmp = c[i];
                c[i] = '*';
                String new_s = String.valueOf(c);
                map.putIfAbsent(new_s, new LinkedList<>());
                map.get(new_s).add(tmp);
                c[i] = tmp;
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] c = word.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            char tmp = c[i];
            c[i] = '*';
            String s = String.valueOf(c);
            if(map.containsKey(s)) {
                if(map.get(s).size() >= 2 || map.get(s).get(0) != tmp) 
                    return true;
            }
            c[i] = tmp;
        }
        return false;
    }
}
