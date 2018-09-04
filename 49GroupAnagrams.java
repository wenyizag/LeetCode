    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs.length == 0) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        
        //思路是用每次遇到一个string，把它sort了，如果map里已经有过该sort，说明是anagram
        //时间复杂度是 m*nlgn
        for(String s : strs){
            //注意用arrays.sort需要把string转换为array
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String s_sort = new String(charArray);
            if(map.containsKey(s_sort)){
                ans.get(map.get(s_sort)).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                ans.add(list);
                map.put(s_sort, ans.size()-1);
            }
        }
        return ans;
    }


        public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs.length == 0) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        
        //这种方法其实跟上一种sort是差不多的，不过是时间复杂度的优化版
        for(String s : strs){
            
            //用数组来记录有多少个字母
            int[] count = new int[26];
            for(char c: s.toCharArray()){
                count[c - 'a']++;
            }
            //例如“eat”，改造后的s_count变成"1a1e1t"
            String s_count = "";
            for(int i = 0; i < 26; i++){
                if(count[i] > 0){
                    //(char)(i+'a')能把对应的数字变成ascII, String.valueOf能把char变成string
                    s_count = s_count + count[i] + String.valueOf((char)(i+'a'));
                }
            }

            if(map.containsKey(s_count)){
                ans.get(map.get(s_count)).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                ans.add(list);
                map.put(s_count, ans.size()-1);
            }
        }
        return ans;
    }