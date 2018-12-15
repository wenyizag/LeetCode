    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() == 0) return ans;
        DP(ans, "", s, 0, 0);
        return ans;
    }
    
    public void DP(List<String> ans, String curString, String s, int index, int count){
        if(count > 4) return;
        if(count == 4 && index == s.length()){
            ans.add(curString);
            return;
        }
        for(int i = 1; i < 4; i++){
            if(index + i > s.length()) break;
            String tmp = s.substring(index, index+i);
            // System.out.println(tmp);
            if((tmp.startsWith("0") && tmp.length() > 1) || (i==3 && Integer.parseInt(tmp) > 255))continue;
            //我发现一个事，就是string也不会跟着recursion变化，这个是引用传递，不是值传递
            DP(ans, curString + tmp + (count==3 ? "" : ".") , s, index+i, count+1);
        }
    }