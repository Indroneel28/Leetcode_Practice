/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //METHOD 2:- BY RUNNING THE LOOP LCM(nodes in A,nodes in B) times.
        ListNode p= headA, q= headB;
        while (true){
            if (p==q)
                return p;
            p= p.next;
            q= q.next;
            //If both p and q reached at same time to null means there is no common element
            if(p==null && q==null)
                return null;
            if (p==null)
                p= headA;
            if (q== null)
                q= headB;
        }
    }
}