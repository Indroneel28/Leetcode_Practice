class LRUCache {
    //WE can solve it using Doubly LinkedList + HashMap
    //In Java, DLL + HashMap = LinkedHashMap

    LinkedHashMap<Integer,Integer> map;
    int size;

    public LRUCache(int capacity) {
        this.map= new LinkedHashMap<>();
        this.size= capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1; //key is not present
        int value= map.get(key);
        map.remove(key);
        map.put(key,value); //remove and update the key
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value); //Bring back to the end(recently used part)
        }
        else if (map.size()<this.size){
            map.put(key,value);
        }
        else{
            map.remove(map.keySet().iterator().next()); //To remove the LRU element
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */