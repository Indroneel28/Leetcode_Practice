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
    public ListNode doubleIt(ListNode head) {
        /*
        if(head.val==0 && head.next==null)
            return head;
        if(head==null)
            return null;
        ListNode p= head;
        long num=0;
        while(p!=null){
            num= num*10 + p.val;
            p= p.next;
        }

        num*=2;
        long dup=num, c=1;
        while (dup>9){
            c*=10;
            dup/=10;
        }

        ListNode node= new ListNode(-1);
        p= node;
        while (c!=0){
            ListNode enter= new ListNode((int)(num/c));
            p.next= enter;
            p= p.next;
            num%=c; c/=10;
        }
        return node.next;
         */

        //CODE IS PERFECT BUT NON-SENSE TEST CASES ARE THERE LIKE 20 DIGITS NUMBERS EXCEEDING LONG MAX SIZE
        //LET'S MAKE ANOTHER CODE

        // if(head==null)
        //     return null;
        // //Let's first reverse the LL
        // head= reverse(head);

        // //Now, let multiply each elements by 2
        // ListNode p= head;
        // int carry= 0;
        // ListNode newList= new ListNode(0);
        // ListNode x= newList;
        // while (p != null){
        //     int num= p.val*2;
        //     ListNode node= new ListNode((num+carry)%10);
        //     carry= (num+carry)/10;
        //     x.next= node;
        //     x= x.next;
        //     p= p.next;
        // }
        // if(carry!=0){
        //     ListNode node= new ListNode(carry);
        //     x.next= node;
        //     x= x.next;
        // }

        // //Let's again reverse the LL
        // newList= newList.next;
        // newList= reverse(newList);
        
        // return newList;

        //CODE IS PERFECT STILL WE HAVE USED 3 LOOPS.
        //LET'S TRY TO SOLVE IN ONE LOOP
        if (head.val > 4)
            head = new ListNode(0, head);
        for(ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4)
                node.val++;
        }
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode curr= head, prev=null;
        while (curr!=null){
            ListNode temp =curr.next;
            curr.next= prev;
            prev= curr;
            curr= temp;
        }
        return prev;
    }
}