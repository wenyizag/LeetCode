class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        return ways(input, map);
    }
    
    public List<Integer> ways(String input, HashMap<String, List<Integer>> map) {
        if(map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {
                List<Integer> left = ways(input.substring(0, i), map);
                List<Integer> right = ways(input.substring(i+1), map);

                for(Integer l : left) {
                    for(Integer r : right) {
                        switch(input.charAt(i)) {
                            case '+':
                                ans.add(l + r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '*':
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        //解释一下为什么只能通过ans的size来判断input里面有没有符号，
        //因为它这个数不一定是单位数，无法根据input的长度为1就说明没有符号
        //有可能input为“11”
        if(ans.size() == 0) ans.add(Integer.valueOf(input));
        map.put(input, ans);
        return ans;
    }
}