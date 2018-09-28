    public boolean isAdditiveNumber(String num) {
        
        if(num.length() < 3) return false;
        
        for(int i = 1; i <= num.length()/2; i++){
            //单位数为0可以
            if(num.charAt(0) == '0' && i > 1) return false;
            Long first = Long.valueOf(num.substring(0, i));
            for(int j = i+1; j-i <= num.length()-j && i <= num.length()-j; j++){
                if(num.charAt(i) == '0' && j > i+1) break;
                Long second = Long.valueOf(num.substring(i,j));
                // System.out.println(first + " " + second);
                if(helper(num, j, first, second)) return true;
            }
        }
        return false;
    }
    
    public boolean helper(String num, int start, Long first, Long second){
        if(start >= num.length()) return true;
        String sum = first + second + "";
        // System.out.println(sum+"sum");
        if(num.startsWith(sum, start)){
            first = second;
            second = Long.valueOf(sum);
            start = start+sum.length();
            return helper(num, start, first, second);
        }else return false;
    }