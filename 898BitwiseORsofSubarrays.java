    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> pre = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for(int a : A){
            Set<Integer> cur = new HashSet<>();
            cur.add(a);
            for(int b : pre){
                cur.add(b | a);
            }
            ans.addAll(cur);
            pre = cur;
        }
        
        return ans.size();
    }