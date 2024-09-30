class CustomStack {
    int top;
    int[] arr;
    public CustomStack(int maxSize) {
        this.top= -1;
        this.arr= new int[maxSize];
        //TC is O(1)
    }

    public void push(int x) {
        if (top+1 == arr.length)
            return;
        arr[++top]= x;
        //TC is O(1)
    }

    public int pop() {
        if (top==-1)
            return -1;
        return arr[top--];
        //TC is O(1)
    }

    public void increment(int k, int val) {
        for (int i=0; i<Math.min(k,top+1); i++)
            arr[i]+=val;
        //TC is O(k)
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */