//Solution 1
    // Using Recursion
   int idx = 0;
    public String decodeString(String s) { 		
        String ans = "";
        int time = 0;
        while(idx < s.length()) {
            char cur = s.charAt(idx);
            idx++;
            if(Character.isDigit(cur)) {
                time = time*10 + cur-'0';
            }else if(cur == '[') {
                String tmp = decodeString(s);
                while(time > 0) {
                    ans += tmp;
                    time--;
                }
            }else if(cur == ']') {
                return ans;
            }else {
                ans += cur;
            }
        }
        return ans;
    }

 //Solution 2
     public String decodeString(String s) {
        //Using Two Stack
   		Stack<Integer> stack = new Stack<>();
    		Stack<String> string = new Stack<>();
    		
    		String ans = "";
    		int i = 0;
    		while(i < s.length()) {
    			if(Character.isDigit(s.charAt(i))) {
    				int time = 0;
    				while(Character.isDigit(s.charAt(i))) {
    					time = time*10 + s.charAt(i++)-'0';
    				}
    				stack.push(time);
    			}else if(s.charAt(i) == '[') {
    				string.push(ans);
    				ans = "";
    				i++;
    			}else if(s.charAt(i) == ']') {
    				int time = stack.pop();
    				StringBuilder tmp = new StringBuilder(string.pop());
    				while(time > 0) {
    					tmp.append(ans);
    					time--;
    				}
    				ans = tmp.toString();
    				i++;
    			}else {
    				ans += s.charAt(i++);
    			}
    		}
    		return ans;
    }
