    //比起combination sum I就多了个检查tmp的size的步骤，不多说
    public static List<List<Integer>> combinationSum3(int k, int n) {
    		List<List<Integer>> ans = new ArrayList<>();
    		ArrayList<Integer> tmp = new ArrayList<>();
    		helper(k, n, 1, ans, tmp);
    		return ans;      
    }
    public static void helper(int k, int n, int index, List<List<Integer>> ans, 
    		ArrayList<Integer> tmp) {
    		if( n < 0 || tmp.size() > k) return;
    		if(n == 0 && tmp.size() == k) {
    			ans.add(new ArrayList<>(tmp));
    			return;
    		}
		for(int i = index; i <= 9; i++) {
			if(i > n) return;
			  				
			tmp.add(i);
			helper(k, n-i, i+1, ans, tmp);
			tmp.remove(tmp.size()-1);
		}   			    					
    }