    public String addBinary(String a, String b) {
        int al = a.length()-1, bl = b.length()-1;
        
        StringBuilder ans = new StringBuilder("");
        int sum, carry = 0;
        
        for(int i = al, j = bl; i >= 0 || j >= 0; i--, j--){
            sum = carry;
            if(i >= 0) sum += a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';
            ans.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry > 0) ans.append(carry);
        
        return ans.reverse().toString();
    }