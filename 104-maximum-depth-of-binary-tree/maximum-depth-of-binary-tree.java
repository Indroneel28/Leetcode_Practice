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
    //METHOD 1:- USING DFS
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left= 1 + maxDepth(root.left);
        int right= 1 + maxDepth(root.right);
        return Math.max(left,right);
    }
    //TC is O(n) and SC is O(n)
}