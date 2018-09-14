    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, n, n, "");
        return ans;
    }
    
    public void helper(List<String> ans, int left, int right, String s){
        if(left > right) return;
        if(left == 0 && right == 0) {ans.add(s); return;}
        if(left > 0) helper(ans, left-1, right, s+"(");
        if(right > 0) helper(ans, left, right-1, s+")");
    }