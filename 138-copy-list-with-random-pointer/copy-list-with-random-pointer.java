/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //BRUTE FORCE METHOD:- USING HASHMAP
        /*
        Node newHead= new Node(-1);
        Node p= newHead, q= head;

        HashMap<Node,Node> map= new HashMap<>(); //store old nodes and new nodes
        map.put(null,null);

        while (q!=null){
            p.next= new Node(q.val);
            p= p.next;
            map.put(q,p);
            q= q.next;
        }

        newHead= newHead.next; //Remove -1
        p= newHead; q=head;
        while (q!=null){
            p.random= map.get(q.random);
            p= p.next;
            q= q.next;
        }

        return newHead;
         */
        //TC is O(2n) and SC is O(2n)


        //OPTIMIZED BRUTE FORCE METHOD:- USING HASHMAP
        /*
        HashMap<Node,Node> map= new HashMap<>(); //store old nodes and new nodes
        map.put(null,null);

        Node q= head;
        while (q!=null){
            Node node= new Node(q.val);
            map.put(q,node);
            q= q.next;
        }

        q=head;
        while (q!=null){
            Node node= map.get(q);
            node.next= map.get(q.next);
            node.random= map.get(q.random);
            q= q.next;
        }

        return map.get(head);
         */
        //TC is O(2n) and SC is O(2n)

        //OPTIMAL SOLUTION:-
//        Step 1: Traverse the original node and create a copy of each node and insert it in between the original node and the next node.
//        Step 2: Traverse this modified list and for each original node that has a random pointer, set the copied node’s random pointer to the corresponding copies random node. If the original node’s random pointer is full, set the copied node’s random pointe to null as well.
//        Step 3: RecursionTraverse the modified list again and extract the coped nodes by breaking the links between the original nodes and the copied nodes. Revert the original list to its initial state by fixing the next pointers.
//        Step 4: Return the head of the deep copy obtained after extracting the copied nodes from the modified list.

        //Step 1
        Node temp= head;
        while (temp!=null){
            Node node= new Node(temp.val);
            node.next= temp.next;
            temp.next= node;
            temp= temp.next.next;
        }

        //Step 2
        temp= head;
        while (temp!=null){
            if (temp.random!=null)
                temp.next.random= temp.random.next;
            temp= temp.next.next;
        }

        //Step 3
        temp= head;
        Node newHead= new Node(-1), p= newHead;
        while (temp!=null){
            p.next= temp.next;
            temp.next= temp.next.next;
            temp= temp.next;
            p= p.next;
        }
        return newHead.next;
        //TC is O(3n) and SC is O(n)
    }
}