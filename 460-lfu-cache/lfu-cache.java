class LFUCache {
    //METHOD:- USING LRU CONCEPT, DLL AND HASHMAP (STRIVER)
    class DLLNode {
        int key;
        int value;
        int frequency;
        DLLNode previous, next;

        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.previous = this.next = null;
        }
    }

    class DoublyLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoublyLinkedList() {
            //Create two dummy nodes
            this.head = new DLLNode(-1, -1);
            this.tail = new DLLNode(-1, -1);
            this.listSize = 0;
            head.next = tail;
            tail.previous = head;
        }

        public void addNode(DLLNode nodeToBeInserted) {
            DLLNode afterHead = head.next;
            nodeToBeInserted.next = afterHead;
            afterHead.previous = nodeToBeInserted;
            head.next = nodeToBeInserted;
            nodeToBeInserted.previous = head;
            this.listSize++;
        }

        public void removeNode(DLLNode nodeToBeRemoved) {
            //No need of edge cases here //According to constraints edge cases will not come
            DLLNode prevNode = nodeToBeRemoved.previous;
            DLLNode nextNode = nodeToBeRemoved.next;
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
            nodeToBeRemoved = null; //Good Practice
            this.listSize--;
        }
    }

    final int capacity;
    int currSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoublyLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null)
            return -1;
        updateNode(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (cache.containsKey(key)) {
            DLLNode currentNode = cache.get(key);
            currentNode.value = value;
            updateNode(currentNode);
        } else {
            currSize++;
            if (currSize > capacity) {
                //get minimum frquency list
                DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.previous.key);
                minFreqList.removeNode(minFreqList.tail.previous);
                currSize--;
            }
            //reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            //get the list with frquency 1, and then add new node into the list, as well as into LFU cache
            DoublyLinkedList currList = frequencyMap.getOrDefault(1, new DoublyLinkedList());
            currList.addNode(newNode);
            frequencyMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode currNode) {
        int currFreq = currNode.frequency;
        DoublyLinkedList currList = frequencyMap.get(currFreq);
        currList.removeNode(currNode);

        if (currFreq == minFrequency && currList.listSize == 0)
            minFrequency++;

        currNode.frequency++;

        //add current node to another list has current frequency +1,
        //if we do not have he list with this frequency, initialize it
        DoublyLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoublyLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */