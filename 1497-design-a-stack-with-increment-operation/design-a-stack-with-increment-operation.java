//METHOD 2:- USING LAZY PROPAGATION
class CustomStack {
    int top;
    int[] arr;
    int[] increment;
    public CustomStack(int maxSize) {
        this.top= -1;
        this.arr= new int[maxSize];
        this.increment= new int[maxSize];
        //TC is O(1)
    }

    public void push(int x) {
        if (top== arr.length-1)
            return;
        arr[++top]= x;
        //TC is O(1)
    }

    public int pop() {
        if (top==-1)
            return -1;

        int answer= increment[top]+arr[top];
        if (top>0){
            increment[top-1]+= increment[top]; //Lazy Propagation
        }
        increment[top]= 0;
        arr[top]= 0;
        top--;
        return answer;
        //TC is O(1)
    }

    public void increment(int k, int val) {
        if (top==-1)
            return;
        else if (k>top+1){
            increment[top]+=val;
        }
        else {
            increment[k-1]+=val;
        }
        //TC is O(1)
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */