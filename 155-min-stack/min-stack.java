public class MinStack {

    //METHOD 1:- USING ARRAY
    /*
    Methods pop, top and getMin operations will always be called on non-empty stacks. //Most IMP Line
    At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
     */

    //METHOD 2:- USING LINKEDLIST

    //METHOD 3:- USING STACK AND Pair Class
    Stack<Pair> stack;
    public MinStack() {
        this.stack= new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.push(new Pair(val,val));
        else
            stack.push(new Pair(val,Math.min(val,stack.peek().minValue)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().minValue;
    }
    //TC is O(1) and SC is O(2n) coz we are storing pairs
}

//Pair Class
class Pair{
    int value; //Will store the value
    int minValue; //Will store the minimum till now

    Pair next; //Point to the next Pair

    //Constructor
    public Pair(int value, int minValue){
        this.value= value;
        this.minValue= minValue;
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