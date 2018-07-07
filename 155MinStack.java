class MinStack {

    /** initialize your data structure here. */
    
    //这道题的难点其实就是只用一个stack，并且随时知道它的min，如果min被pop出去了，那得在不排序的情况下知道第二个min
    //所以思路是在检查push的时候，发现将push的这个val比当前min小，那么把当前min先push进去，于是即使val被pop了，排在
    //它下面的一个就是上一次的min。
    //所以pop的时候发现min被pop了，就再pop一次。
    Stack<Integer> minStack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public MinStack() {    
    }
    
    public void push(int x) {
        //这里有一个易错点，min == x的时候，也要push，说明有两个最小值，比如push{0,1,0}，实际应该push的是{0，1，0，0}
        if(min >= x){
            minStack.push(min);
            min = x;
        }
        minStack.push(x);
    }
    
    public void pop() {
        if(minStack.pop() == min){
            min = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
