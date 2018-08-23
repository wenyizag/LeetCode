  public List<List<Integer>> generate(int numRows) {
    		List<List<Integer>> ans = new ArrayList<>();
    		if(numRows == 0) return ans;
      
    		ans.add(new ArrayList<>());
            ans.get(0).add(1);
    		int row = 1;
    		while(row < numRows) {
    			List<Integer> newRow = new ArrayList<>();
    			newRow.add(1);
    			int size = ans.get(row-1).size();
    			for(int i = 0; i < size-1; i++) {
    				int tmp = ans.get(row-1).get(i) + ans.get(row-1).get(i+1);
    				newRow.add(tmp);
    			}
    			newRow.add(1);
    			ans.add(newRow);
                row++;
    		}
        return ans;
    }