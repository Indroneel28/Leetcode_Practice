class MyQueue {
    //Two stacks are used
    Stack<Integer> stack, store;
    public MyQueue() {
        this.stack= new Stack<>();
        this.store= new Stack<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()){ //Move all elements from stack to store
            store.push(stack.pop());
        }
        stack.push(x); // Add x to stack
        while (!store.isEmpty()){ //Again move all elements from store to stack
            stack.push(store.pop());
        }
        //TC is O(n)
    }

    public int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.pop();
        //TC is O(1)
    }

    public int peek() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
        //TC is O(1)
    }

    public boolean empty() {
        return stack.isEmpty();
        //TC is O(1)
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */