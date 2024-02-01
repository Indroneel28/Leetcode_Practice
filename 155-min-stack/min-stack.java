class MinStack {
    int top;
    int[] arr;
    public MinStack() {
        top=-1;
        arr= new int[3*10000+1];
    }

    public void push(int val) {
        arr[++top]= val;
    }

    public void pop() {
        arr[top--]= 0;
    }

    public int top() {
        return arr[top];
    }

    public int getMin() {
        int min= arr[0];
        for (int i=1; i<=top; i++) {
            if (arr[i]<min)
                min= arr[i];
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */