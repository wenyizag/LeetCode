    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return helper(s, 0, s.length()-1);
    }
    
    public int helper(String s, int l, int h){
        if(l > h) return 1;
        if(s.charAt(l) == '0') return 0;
        if(l == h) return 1; //递归的时候single digit和null都应该返回1，null按理说应该是0，为什么是1呢，
        //因为s[i]=s[i-1]+s[i-2]，如果s[i-1]都s[i-2]valid的话，例如"11",那就等于"1"+"", null也应该等于1
        
        int sum = helper(s, l+1, h);
        int two = (s.charAt(l)-'0') * 10 + (s.charAt(l+1)-'0');
        if(two <= 26) sum += helper(s, l+2, h);
        
        return sum;
    }


    //递归
        public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return helper(s, 0, s.length()-1);
    }
    
    //这个递归如果不用map来memorize一下的话，时间就会巨高
    HashMap<Integer, Integer> map = new HashMap<>();
    public int helper(String s, int l, int h){
        if(map.containsKey(l)) return map.get(l);
        if(l > h) return 1;
        if(s.charAt(l) == '0') return 0;
        if(l == h) return 1; //递归的时候single digit和null都应该返回1，null按理说应该是0，为什么是1呢，
        //因为s[i]=s[i-1]+s[i-2]，如果s[i-1]都s[i-2]valid的话，例如"11",那就等于"1"+"", null也应该等于1
        
        int sum = helper(s, l+1, h);
        int two = (s.charAt(l)-'0') * 10 + (s.charAt(l+1)-'0');
        if(two <= 26) sum += helper(s, l+2, h);
        
        map.put(l, sum);
        
        return sum;
    }