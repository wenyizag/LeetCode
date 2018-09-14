    public List<String> letterCombinations(String digits) {
        String[] charMap = {"", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
        //这个linkedList当做queue用。。
        LinkedList<String> ans = new LinkedList<>();
        
        if(digits.length() == 0) return ans;
        ans.add("");
        
        //诀窍就是记下queue的size，然后遍历
        for(char c : digits.toCharArray()){
            String curMap = charMap[c-'1'];
            int size = ans.size();
            for(int i = 0; i < size; i++){
                String prefix = ans.poll();
                for(char cur : curMap.toCharArray()){
                    ans.add(prefix + cur);
                }
            }
        }
        return ans;
    }


    public List<String> letterCombinations(String digits) {
        String[] charMap = {"", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
        List<String> ans = new LinkedList<>();
        
        if(digits.length() == 0) return ans;
        helper(charMap, digits, "", 0, ans);
        return ans;
    }
    
    //DFS，注意终止条件和循环怎么写
    public void helper(String[] charMap, String digits, String curString, int index, List<String> ans){
        if(index >= digits.length()){
            ans.add(curString);
            return;
        }
        String curMap = charMap[digits.charAt(index) - '1'];
        for(char c : curMap.toCharArray()){
            helper(charMap, digits, curString+c, index+1, ans);
        }
    }