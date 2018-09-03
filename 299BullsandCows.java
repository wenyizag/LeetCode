    public String getHint(String secret, String guess) {
        //第一直觉是利用hashmap，走两边for
        int bull = 0, cow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        
        for(int i = 0; i < s.length; i++){
            if(s[i] == g[i]) {
                bull++;
                g[i] = '#';
            }
            else{
                map.put(s[i], map.getOrDefault(s[i], 0)+1);
            }
        }
        for(int i = 0; i < g.length; i++){
            if(map.containsKey(g[i]) && map.get(g[i]) > 0){
                cow++;
                map.put(g[i], map.get(g[i])-1);
            }
        }
        return bull+"A"+cow+"B";       
    }

//Solution 2
        public String getHint(String secret, String guess) {

        int bull = 0, cow = 0;
        int[] nums = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        
        for(int i = 0; i < s.length; i++){
            int s_i = s[i] - '0';
            int g_i = g[i] - '0';
            if(s_i == g_i) {
                bull++;
            }
            else{
                if(nums[s_i] > 0){
                    cow++;
                }
                if(nums[g_i] < 0){
                    cow++;
                }
                nums[s_i]--;
                nums[g_i]++;
            }
        }

      return bull+"A"+cow+"B";
    }