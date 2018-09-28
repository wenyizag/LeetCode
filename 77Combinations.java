    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n == 0 || k == 0) return ans;
        helper(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> list, int index, int n, int count){
        if(count == 0){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i = index; i <= n; i++){
            list.add(i);
            helper(ans, list, i+1, n, count-1);
            list.remove(list.size()-1);
        }
    }