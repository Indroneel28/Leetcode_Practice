/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //NOTE:- Storing in variables now NOT WORKING
        
        //BRUTE FORCE METHOD:- BY STORING IN STACK
        /*
        Stack<Integer> stack= new Stack<>();
        for (ListNode i= head; i!=null; i= i.next){
            stack.push(i.val);
        }
        for (ListNode i= head; i!=null; i= i.next){
            if (stack.pop()!=i.val)
                return false;
        }
        return true;
        */
        //TC is O(2n) and SC is O(n)


        //OPTIMIZED METHOD
        //Step 1:- Find the middle using Tortoise-hoare algorithm
        ListNode slow= head, fast= head;
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        //Step 2:- Reverse from middle to end
        ListNode prev= null;
        while (slow!=null){
            ListNode temp= slow.next;
            slow.next= prev;
            prev= slow;
            slow= temp;
        }
        //Step 3:- Compare from head and prev(newHead)
        ListNode p= head, q= prev;
        while (p!=null && q!=null){
            if(p.val!=q.val)
                return false;
            p= p.next;
            q= q.next;
        }
        return true;
        //TC is O(n/2 + n/2 + n/2) and SC is O(1)
    }
}