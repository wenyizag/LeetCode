   public static int longestSubstring(String s, int k) {
    		return longest(s, k, 0, s.length()-1);
    }
    
    //这种方法最重要的思路就是"迭代"
    //先计算s中出现的字母的count
    //然后查找第一次小于k的字母的index，以此为分割，返回（start, i-1）和(i+1, end)中较大的那个
    public static int longest(String s, int k, int start, int end) {
    		//总长度都没有k，每一个符合，可以直接返回了
    		if((end-start+1) < k) return 0;
    		int[] count = new int[26];
    		for(int i = start; i<=end; i++) {
    			count[s.charAt(i)-'a']++;
    		}
    		for(int i = start; i <= end; i++) {
    			//如果不出现小于k的频率的话，这个if被跳过，不进入迭代直接返回。
    			if(count[s.charAt(i)-'a'] < k) {
    				int j = i+1;
    				//有没有连续的小于k的，可以都不要了
    				while(j <= end && count[s.charAt(j)-'a'] < k) j++;
    				return Math.max(longest(s, k, start, i-1), longest(s, k, j, end));
    			}
    		}
    		return end-start+1;
    }