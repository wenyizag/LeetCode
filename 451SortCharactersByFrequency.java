class Solution {
    class Pair {
        char val;
        int count;
        public Pair(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        if(s.length() == 0) return "";
        int[] counts = new int[128];
        
        for(char c : s.toCharArray()) {
            counts[c]++;
        }
        
        List<Pair> p = new LinkedList<>();
        for(int i = 0; i < 128; i++) {
            if(counts[i] != 0) {
                char c = (char)(i);
                p.add(new Pair(c, counts[i]));
            }
        }
        
        Collections.sort(p, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return - (a.count - b.count);
            }
        });
        
        StringBuilder ans = new StringBuilder("");
        for(Pair cur : p) {
            int time = cur.count;
            for(int i = 0; i < time; i++)
                ans.append(cur.val);
            
        }
        return ans.toString();
    }
}