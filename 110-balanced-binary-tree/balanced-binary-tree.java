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
    //METHOD 2:- USING DFS
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        int left= maxDepth(root.left);
        int right= maxDepth(root.right);

        if (Math.abs(left-right)>1)
            return false;
        
        //Checking for other nodes
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int maxDepth(TreeNode root){
        if (root==null)
            return 0;
        int left= 1 + maxDepth(root.left);
        int right= 1 + maxDepth(root.right);
        return Math.max(left,right);
    }
    //TC is O(n^2) and SC is O(2n)
}