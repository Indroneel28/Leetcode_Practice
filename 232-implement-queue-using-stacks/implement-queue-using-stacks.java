class MyQueue {

    //METHOD 1:- Two stacks are used
    /*
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
     */

    //Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
    //In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

    Stack<Integer> stack1, stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        //TC is O(1)
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return -1;
        if (stack2.isEmpty()) {
            //Move from stack 1 to stack 2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        //TC is O(1) actually amortized O(1)
    }

    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return -1;
        if (stack2.isEmpty()) {
            //Move from stack 1 to stack 2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
        //TC is O(1) actually amortized O(1)
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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