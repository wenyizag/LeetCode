//solution 1. count
class Solution {
    public boolean checkValidString(String s) {
        int max_op = 0; //maximun number of '('
        int min_op = 0; //mininum number of '('
        
        for(char c : s.toCharArray()) {
            if(c == '(') min_op++; else min_op--;
            if(c != ')') max_op++; else max_op--;
            if(max_op < 0) return false;
            min_op = Math.max(0, min_op);
        }
        
        return min_op == 0;
    }
}

//solution 2. dp
class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        if(len == 0) return true;
        boolean[][] dp = new boolean[len][len];
        char[] c = s.toCharArray();
        
        for(int i = 0; i < len; i++) {
            if(c[i] == '*') dp[i][i] = true;
        }
       
        for(int i = 1; i < len; i++) {
            for(int j = i-1; j >= 0; j--) {
                if((c[i] == ')' || c[i] == '*') &&
                   (c[j] == '(' || c[j] == '*')) {
                    if(i - j <= 1 || dp[j + 1][i - 1]) {
                      dp[j][i] = true;
                        continue;
                    }
                }
                    
                for(int k = j; k < i; k++) {
                    if(dp[j][k] && dp[k+1][i]) {
                        dp[j][i] = true;
                        break;
                    }      
                }
            }
        }
        return dp[0][len-1];
    }
 
    
    //solution 3
        public boolean checkValidString(String s) {
        int leftParenthesis = 0, rightParenthesis = 0;
        int star = 0;
    
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') star++;
            else if(s.charAt(i) == '(') {
                leftParenthesis++;
            }else {
                if(leftParenthesis > 0) leftParenthesis--;
                else if(star > 0) star--;
                else return false;
            }
        }
        if(leftParenthesis > star) return false;
        // System.out.println("test");
        star = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '*') star++;
            else if(s.charAt(i) == ')') {
                rightParenthesis++;
            }else {
                if(rightParenthesis > 0) rightParenthesis--;
                else if(star > 0) star--;
                else return false;
            }
        }

        return rightParenthesis <= star;
    }
}
