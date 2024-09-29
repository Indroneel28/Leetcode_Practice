public class MinStack {

    //METHOD 1:- USING ARRAY
    /*
    Methods pop, top and getMin operations will always be called on non-empty stacks. //Most IMP Line
    At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
     */
    /*
    int[] arr; int top;
    public MinStack() {
        this.arr= new int[30000];
        top= -1;
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
        for (int i=1; i<=top; i++){
            if (arr[i]<min)
                min= arr[i];
        }
        return min;
        //TC is O(n)
    }
     */

    //METHOD 2:- USING LINKEDLIST
    
    Node head;
    public MinStack() {
        this.head= null;
    }

    public void push(int val) {
        Node node= new Node(val);
        node.next= head;
        head= node;
    }

    public void pop() {
        head= head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        Node p= head;
        int min= Integer.MAX_VALUE;
        while (p!=null){
            if (p.data<min)
                min= p.data;
            p= p.next;
        }
        return min;
        //TC is O(n)
    }
}

//Node Class
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data= data;
        this.next= null;
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