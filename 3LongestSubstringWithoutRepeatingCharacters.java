    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int start=0, max=0;
        for(int i = 0; i < ch.length; i++) {
                //思路就是用一个hashset（不用int[26]是因为有各种各样的字符出现），
                //每当有重复字符出现的时候，就计算【该重复字符的前一位到start的距离】, 然后把start改为重复字符第一次出现位置的后一位
                //注意为什么要s.indexOf(ch[i], start) != i，比如测试 tmmhsgt, 这里第二次出现的t，其实不能算作重复
                //因为有m的出现，我们已经把start挪到2了，这个时候s.indexOf(ch[i], start)查找出来的就是当前t的位置，为i
        		if(set.contains(ch[i]) && s.indexOf(ch[i], start) != i) {
        			max = Math.max(max, i-start); 
        			start = s.indexOf(ch[i], start)+1;
        		}else {
        			set.add(ch[i]);
        		}
        	}
        //最后我再比较一次是因为，可能一直都没出现重复字符，则我们的max没有被更新
        max = Math.max(max, ch.length-start);
        return max;
    }