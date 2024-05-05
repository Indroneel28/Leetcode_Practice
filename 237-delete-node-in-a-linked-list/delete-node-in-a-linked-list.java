/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val= node.next.val;
        node.next= node.next.next;
        //REMEMBER
        //Question should be delete value not node
        //This code is perfect
        //The value of each node in the list is unique.
        //The node to be deleted is in the list and is not a tail node.
    }
}