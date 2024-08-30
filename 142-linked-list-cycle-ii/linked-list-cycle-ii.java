/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //BRUTE FORCE APPROACH:- USING HASHSET
        /*
        HashSet<ListNode> set= new HashSet<>();
        ListNode p= head;
        while (p!=null){
            if (!set.add(p))
                return p;
            p= p.next;
        }
        return null;
         */
        //TC is O(n) and SC is O(n)

        //OPTIMAL METHOD:- BY ANALYZING AND HOARE-TORTOISE ALGORITHM
        ListNode fast= head, slow= head;
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
            if (slow==fast){
                //Collision => The Loop is detected
                slow= head;
                while (slow!=fast){
                    slow= slow.next;
                    fast= fast.next;
                }
                return slow; //Loop starting here
            }
        }
        //Loop does not exist
        return null;
        //TC is O(n) and SC is O(1)
    }
}