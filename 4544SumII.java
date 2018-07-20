    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            //这个想法其实很简单，就是把4sum转换为2sum
            //先遍历A+B的可能结果，用map储存
            //再遍历C+D，查找map中有没有-C-D的关键词，如果有，就把它的value加上去
            HashMap<Integer, Integer> map = new HashMap<>();
    		int len = A.length;
    		int ans = 0;
    		
    		for(int i = 0; i < len; i++) {
    			for(int j = 0; j < len; j++) {
    				map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);
    			}
    		}
    		
    		for(int i = 0; i < len; i++) {
    			for(int j = 0; j < len; j++) {
    				if(map.containsKey(-C[i]-D[j])) {
    					ans += map.get(-C[i]-D[j]);
    				}
    			}
    		}
    		return ans; 
    }