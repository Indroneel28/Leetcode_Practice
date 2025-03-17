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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
            return 0;
        int l= maxDepth(root.left);
        int r= maxDepth(root.right);

        return Math.max(l+r, Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
    private int maxDepth(TreeNode node){
        if (node==null)
            return 0;
        int left= maxDepth(node.left);
        int right= maxDepth(node.right);
        return Math.max(left,right) + 1;
    }
    //TC is O(n^2) and SC is O(n)
}