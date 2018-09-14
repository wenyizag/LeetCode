    public String complexNumberMultiply(String a, String b) {
        //不明白为什么"+"也是特殊字符。。
        String[] as = a.split("\\+|i");
        String[] bs = b.split("\\+|i");
        
        int[] ai = new int[2];
        int[] bi = new int[2];
        for(int i = 0; i < 2; i++){
            ai[i] = Integer.parseInt(as[i]);
            bi[i] = Integer.parseInt(bs[i]);
            System.out.println(ai[i] + " "+bi[i]);
        }
        int front = ai[0]*bi[0] - ai[1]*bi[1];
        int back = ai[1]*bi[0] + ai[0]*bi[1];
        return front + "+" + back + "i";
    }