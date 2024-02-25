class MyComparator implements Comparator<Integer>{
    public int compare(Integer i, Integer j){
        return i.compareTo(j);
    }
}
class SmallestInfiniteSet{
    ArrayList<Integer> list;
    public SmallestInfiniteSet() {
        this.list= new ArrayList<Integer>();
        for (int i=1; i<=1000; i++)
            list.add(i);
    }

    public int popSmallest() {
        return list.remove(0);
    }

    public void addBack(int num) {
        if (!list.contains(num))
            list.add(num);
        list.sort(new MyComparator());
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */