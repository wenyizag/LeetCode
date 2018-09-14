    public int calculate(String s) {
        //虽然很好理解，但自己没想出来，基本就照抄了一遍code
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < c.length; i++){
            
            if(Character.isDigit(c[i])){
                num = num*10 + (c[i] - '0');
            }

            if((!Character.isDigit(c[i]) && c[i] != ' ') || i == c.length-1){
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop()*num);
                else if(sign == '/') stack.push(stack.pop()/num);
                sign = c[i];
                num = 0;
            }

        }
        int ans = 0;
        while(!stack.isEmpty()) { ans += stack.pop(); }
        
        return ans;
    }