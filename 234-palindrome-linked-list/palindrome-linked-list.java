class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next==null){
            return true;
        }
        else if (head.next.next==null){
            return head.val==head.next.val;
        }
        //Find the middle of the LL 
        ListNode fast= head, slow= head;
        while (fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode middle= slow;
        //Reverse half part of LL after middle
        ListNode curr= middle, prev= null;
        while (curr!=null){
            ListNode temp= curr.next;
            curr.next= prev;
            prev= curr;
            curr= temp;
        }
        //Now, prev and head are two pointers at starting and end
        ListNode p= head, q= prev;
        while (p!=null && q!=null){
            System.out.println(p.val+" "+q.val);
            if (p.val!=q.val)
                return false;
            p= p.next;
            q= q.next;
        }
        return true;
    }
}