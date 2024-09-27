class MyStack {

    //METHOD 1:- Two Queues queue and store are used
    /*
    Queue<Integer> queue, store;
    public MyStack() { //Constructor
        this.queue= new LinkedList<>();
        this.store= new LinkedList<>();
    }

    public void push(int x) {
        while (!queue.isEmpty()){ //Move all elements from queue to store
            store.offer(queue.poll());
        }
        queue.offer(x); //Add x in queue
        while (!store.isEmpty()){ //Move again all elements from store to queue
            queue.offer(store.poll());
        }
        //TC to push is O(2n)
    }

    public int pop() {
        if (queue.isEmpty())
            return -1;
        return queue.poll();
        //TC to pop is O(1)
    }

    public int top() {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
        //TC to peek is O(1)
    }

    public boolean empty() {
        return queue.isEmpty();
        //TC to check empty is O(1)
    }
     */

    //FOLLOW-UP QUESTION:- Can you implement the stack using only one queue?
    Queue<Integer> queue;
    public MyStack() {
        this.queue= new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size= queue.size();
        for (int i=0; i<size-1; i++){
            queue.offer(queue.poll());
        }
        //TC to offer is O(n)
    }

    public int pop() {
        if (queue.isEmpty())
            return -1;
        return queue.poll();
        //TC to poll is O(1)
    }

    public int top() {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
        //TC to peek is O(1)
    }

    public boolean empty() {
        return queue.isEmpty();
        //TC to check empty is O(1)
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */