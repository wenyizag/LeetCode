    public String countAndSay(int n) {
        //这个题就考了stringbuilder的一些用法吧。。。用string是不行的
        StringBuilder pre = new StringBuilder("1");
        
        int count = 1;
        for(int i = 1; i < n; i++){
            StringBuilder cur = new StringBuilder("");
            for(int j = 0; j < pre.length(); j++){
                count = 1;
                while(j < pre.length()-1 && pre.charAt(j) == pre.charAt(j+1)) {count++; j++;}
                cur.append(count).append(pre.charAt(j));
            }
            pre = cur;
        }
        return pre.toString();
    }