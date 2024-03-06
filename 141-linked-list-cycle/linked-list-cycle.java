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
    public boolean hasCycle(ListNode head) {
        //By using Tortoise and Hare Algorithm
        ListNode slow= head, fast= head;
        while (fast != null && fast.next!=null){
            //If both pointer meets means loop is there else it's not possible
            slow= slow.next;
            fast= fast.next.next;
            if(slow==fast)
                return true;
        }
        //if while loop ends means the last node's next is null that is loop is not there
        return false;
    }
}