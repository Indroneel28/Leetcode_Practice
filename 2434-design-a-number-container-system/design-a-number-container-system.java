class NumberContainers {

    HashMap<Integer,Integer> map; //Key:- Index  Value:- Number
    HashMap<Integer, TreeSet<Integer>> store; //Key:- Number  Value:- Set of indices
    public NumberContainers() {
        // Initializes the number container system.
        this.map= new HashMap<>();
        this.store= new HashMap<>();
    }

    public void change(int index, int number) {
        // Fills the container at index with the number. If there is already a number at that index, replace it.
        if (map.containsKey(index)){
            int oldNum= map.get(index);
            store.get(oldNum).remove(index);
            if (store.get(oldNum).isEmpty())
                store.remove(oldNum);
        }
        store.putIfAbsent(number,new TreeSet<>());
        store.get(number).add(index);
        map.put(index,number);
    }

    public int find(int number) {
        // Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
        if (store.containsKey(number))
            return store.get(number).first();
        else
            return -1; //NUmber does not exist
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */