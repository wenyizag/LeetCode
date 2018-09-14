    public double myPow(double x, int n) {
        if(n > 0) return pow(x, n);
        else return 1/pow(x, n);
    }
    
    public double pow(double x, int n){
        if(n == 0) return 1;
        double half = pow(x, n/2);
        if((n & 1) == 1) return half * half * x;
        else return half * half;
    }