//solution 1
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = -1, maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            maxLen = Math.max(maxLen, i-left);
            map.put(c, i);
        }
        return maxLen;
    }

//solution 2, 用数组代替hashmap的精简版
    public int lengthOfLongestSubstring(String s) {
        int[] pre_position = new int[256];
        Arrays.fill(pre_position, -1);
        char[] c = s.toCharArray();
        
        int left = -1, max = 0;
        for(int i = 0; i < c.length; i++) {
            left = Math.max(left, pre_position[c[i]]);
            max = Math.max(max, i - left);
            // System.out.println("i " + i + " left " + left);
            pre_position[c[i]] = i;
        }
        return max;
    }
