class MedianFinder {
    ArrayList<Integer> list;
    int len;
    public MedianFinder() {
        list=new ArrayList<>();
        len= 0;
    }

    public void addNum(int num) {
        for (int i=0; i<len; i++){
            if (list.get(i)>=num) {
                list.add(i, num);
                len++;
                return;
            }
        }
        list.add(num);
        len++;
    }

    public double findMedian() {
        if (len%2==1)
            return list.get(len/2);
        else {
            if (len==0)
                return 0;
            return (list.get(len / 2) + list.get(len / 2 - 1)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */