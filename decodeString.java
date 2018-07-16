//Solution 1
    // Using Recursion
    int pos = 0;
    public String decodeString(String s) { 		
    		String ans = "";
    		String num = "";
    		int i = pos;
    		while(i < s.length()) {
    			if(!Character.isDigit(s.charAt(i)) && 
    			   s.charAt(i) != '[' && s.charAt(i) != ']') {
    				ans += s.charAt(i++);
    			}
    			else if(Character.isDigit(s.charAt(i))) {
				    num += s.charAt(i++);
    			}else if(s.charAt(i) == '[') {
    				pos = i+1;
    				String tmp = decodeString(s);
    				for(int n = Integer.valueOf(num); n > 0; n--)
    					ans += tmp;
    				i = pos;
    				num = "";
    			}else if(s.charAt(i) == ']') {
    				pos = ++i;
    				return ans;
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