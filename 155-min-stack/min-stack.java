class MinStack {
    //METHOD 4:- USING TWO STACKS
    Stack<Integer> stack, minStack;
    public MinStack() {
        this.stack= new Stack<>();
        this.minStack= new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val<=minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        int top= stack.pop();
        if (minStack.peek()==top)
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    //TC is O(1) and SC is O(2n)
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */