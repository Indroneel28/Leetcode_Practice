class Solution {
    public long findScore(int[] nums) {

        //METHOD 1:- USING PRIORITY QUEUE AND HASHSET
        PriorityQueue<Nums> queue = new PriorityQueue<>(new Comparator<Nums>() {
            @Override
            public int compare(Nums o1, Nums o2) {
                if (o1.data==o2.data)
                    return Integer.compare(o1.index,o2.index);
                return Integer.compare(o1.data, o2.data);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.add(new Nums(i, nums[i]));
        }

        long score = 0;
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Nums num = queue.poll();
            int i = num.index;

            if (set.contains(i))
                continue;

            score += num.data;
            set.add(i);
            if (i<nums.length-1)
                set.add(i+1);
            if (i>0)
                set.add(i-1);
        }
        return score;
    }
}

class Nums {
    int data;
    int index;

    public Nums(int index, int data) {
        this.data = data;
        this.index = index;
    }

    @Override
    public String toString() {
        return data + " " + index;
    }
}