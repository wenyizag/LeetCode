    public int addDigits(int num) {
        int sum = num;
        while(sum >= 10){
            num = sum;
            sum = 0;
            while(num > 0){
                sum += num%10;
                num = num/10;
                System.out.println(sum + " " + num);
            }

        }
        return sum;
    }