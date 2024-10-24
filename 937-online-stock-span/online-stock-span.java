class StockSpanner {
    class Element{
        int index;
        int value;
        public Element(int index, int value){
            this.index= index;
            this.value= value;
        }
    }
    Stack<Element> stack; //Monotonic Stack
    int count;
    public StockSpanner() {
        this.stack= new Stack<>();
        this.count= -1;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().value<=price)
            stack.pop();
        int left= -1;
        if (!stack.isEmpty())
            left= stack.peek().index;
        count++;
        int span= count-left;
        stack.push(new Element(count,price));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */