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
        //STRIVER'S COURSE
        //BRUTE FORCE APPROACH:- USING HASHSET
        HashSet<ListNode> set= new HashSet<>();
        ListNode p= head;
        while (p!=null){
            if (!set.add(p))
                return p;
            p= p.next;
        }
        return null;
        //TC is O(n) and SC is O(n)
    }
}