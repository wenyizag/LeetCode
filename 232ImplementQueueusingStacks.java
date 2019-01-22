class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1;
    public MyQueue() {
        s1 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // s1.push(x);
        Stack<Integer> tmp = new Stack<>();
        while(!s1.isEmpty()) tmp.push(s1.pop());
        tmp.push(x);
        while(!tmp.isEmpty()) s1.push(tmp.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

