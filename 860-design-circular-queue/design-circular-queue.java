class Node{
    int value;
    Node next;
    public Node(int value){
        this.value= value;
        this.next= null;
    }
}

class MyCircularQueue {
    Node head;
    Node tail;
    int size;
    int maxSize;
    public MyCircularQueue(int k) {
        this.head=null;
        this.tail= tail;
        this.maxSize= k;
        this.size= 0;
    }
    
    public boolean enQueue(int value) {
        if(size==maxSize)
            return false;
        if(head==null){
            head= tail= new Node(value);
        }
        else{
            Node node= new Node(value);
            tail.next= node;
            tail= node;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0)
            return false;
        if(head==tail){
            head= tail= null;
        }
        else{
            head= head.next;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(size==0)
            return -1;
        else
            return head.value;
    }
    
    public int Rear() {
        if(size==0)
            return -1;
        else
            return tail.value;
        
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */