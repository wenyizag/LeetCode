class MapSum {
    class TireNode{
        char c;
        int value;
        TireNode[] child = new TireNode[26];
        public TireNode() {}
        public TireNode(char c, int value) {
            this.c = c;
            this.value = value;
        }
    }
    
    HashMap<String, Integer> map;
    TireNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TireNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        TireNode cur = root;
        if(map.containsKey(key)) {
            val = val - map.get(key);
        }
        map.put(key, val);
        
        for(char c : key.toCharArray()) {
            if(cur.child[c-'a'] == null) {
                cur.child[c-'a'] = new TireNode(c, val);
            }else{
                cur.child[c-'a'].value += val;
            }
            cur = cur.child[c-'a'];
        }
    }
    
    public int sum(String prefix) {
        TireNode cur = root;
        for(char c : prefix.toCharArray()) {
            if(cur.child[c-'a'] == null) {
                return 0;
            }else{
                 cur = cur.child[c-'a'];
            }
        }
        return cur.value;
    }
}
