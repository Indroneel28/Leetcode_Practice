class MinStack {
    //METHOD 5:- STRIVER MATHEMATICAL CALCULATION OP
    Stack<Long> stack;
    long min;
    public MinStack() {
        this.stack= new Stack<>();
        this.min= Integer.MAX_VALUE;
    }

    public void push(long val) {
        if (stack.isEmpty()){
            min= val;
            stack.push(val);
        }
        else{
            if (val<=min){
                stack.push(2*val-min);
                min= val;
            }
            else
                stack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long top= stack.pop();
        if (top<=min){
            min= 2*min-top;
        }
    }

    public long top() {
        if (stack.isEmpty())
            return -1;
        if (stack.peek()<=min)
            return min;
        return stack.peek();
    }

    public long getMin() {
        return min;
    }
    //TC is O(n) and SC is O(1)
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */