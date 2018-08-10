  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    		List<List<Integer>> ans = new ArrayList<>();
    		ArrayList<Integer> tmp = new ArrayList<>();
    		Arrays.sort(candidates);
    		helper(candidates, target, 0, ans, tmp);
    		return ans;      
    }
    public static void helper(int[] candidates, int target, int index, List<List<Integer>> ans, 
    		ArrayList<Integer> tmp) {
    		if(target == 0) {
    			ans.add(new ArrayList<>(tmp));
    			return;
    		}else if(target < 0) {
    			return;
    		}else {
    			for(int i = index; i < candidates.length; i++) {
    				if(candidates[i] > target) return;
    				  				
    				tmp.add(candidates[i]);
    				helper(candidates, target-candidates[i], i+1, ans, tmp);
    				tmp.remove(tmp.size()-1);
                    //注意这比起combination sum I 其实就多了个跳过重复数的操作
                    //跳过的部分得在递归完了后，而不能在一开始，不然像[1,2,2] = 5这样的两个2会被跳过
    				while(i < candidates.length-1 && candidates[i] == candidates[i+1]) i++;
    			}   			    			
    		}
    }