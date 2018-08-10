   public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    		List<List<Integer>> ans = new ArrayList<>();
    		ArrayList<Integer> tmp = new ArrayList<>();
    		Arrays.sort(candidates);
    		helper(candidates, target, 0, ans, tmp);
    		return ans;      
    }
    public static void helper(int[] candidates, int target, int index, List<List<Integer>> ans, 
    		ArrayList<Integer> tmp) {
    		if(target == 0) {
    			//注意是怎么copy一个list的
    			ans.add(new ArrayList<>(tmp));
    			return;
    		}else if(target < 0) {
    			return;
    		}else {
    			for(int i = index; i < candidates.length; i++) {
    				//因为是数组是升序，后面的都会比target大，所以可以直接return了
                    //节省时间
    				if(candidates[i] > target) return;
    				
    				tmp.add(candidates[i]);
    				helper(candidates, target-candidates[i], i, ans, tmp);
                    //这里我之前犯了个致命错误，我把target给加回来了
    				//target += tmp.get(tmp.size()-1);
                    //但其实target不用我加，因为是recursion的，每次recursion里记住了target的值
                    //而tmp需要remove是因为它是按reference传递而不是值传递
    				tmp.remove(tmp.size()-1);
    			}   			    			
    		}
    }