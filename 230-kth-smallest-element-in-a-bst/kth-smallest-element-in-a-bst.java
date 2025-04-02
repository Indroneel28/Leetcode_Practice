/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //METHOD 2:- Using Stack
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr= root;
        Stack<TreeNode> stack= new Stack<>();
        int count= 0;
        while (!stack.isEmpty() || curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr= curr.left;
            }
            curr= stack.pop();
            count++;
            if(count==k)
                return curr.val;
            curr= curr.right;
        }
        return -1;
    }
    //TC is O(n) and SC is O(n) in worst case
}