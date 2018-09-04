    public int numJewelsInStones(String J, String S) {
//这个题虽然是弱智题，但是用到了一个新的小函数，String.contains(substring)，返回boolean，记录一下
        int ans = 0;
        for(char c : S.toCharArray()){
            if(J.contains(c+"")) ans++; 
        }
        return ans;
    }