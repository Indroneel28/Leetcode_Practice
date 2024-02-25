class SmallestInfiniteSet{
    PriorityQueue<Integer> queue;
    public SmallestInfiniteSet() {
        this.queue= new PriorityQueue<>();
        for (int i=1; i<=1000; i++)
            queue.add(i);
    }

    public int popSmallest() {
        return queue.remove();
    }

    public void addBack(int num) {
        if (!queue.contains(num))
            queue.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */