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
    public ListNode oddEvenList(ListNode head) {
        //STRIVER'S COURSE

        //BRUTE FORCE ALGORITHM
        ListNode odd= new ListNode(-1), even= new ListNode(-1);
        ListNode p= odd, q= even;
        ListNode temp= head; int count= 0;
        while (temp!=null){
            if (count%2==0){ //Odd indices(1-based indexing)
                p.next= new ListNode(temp.val);
                p= p.next;
            }
            else{ //Even indices(1-based indexing)
                q.next= new ListNode(temp.val);
                q= q.next;
            }
            temp= temp.next;
            count++;
        }
        p.next= even.next; //Ignore -1
        return odd.next; //Ignore -1
    }
}