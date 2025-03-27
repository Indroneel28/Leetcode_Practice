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
    //METHOD 3:- USING PBT property (OPTIMAL METHOD)
    public int countNodes(TreeNode root) {
        int lh= findLeftHeight(root);
        int rh= findRightHeight(root);
        if (lh==rh)
            return (1<<lh)-1; // i.e. Math.pow(2,lh)-1
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int findLeftHeight(TreeNode root){
        if (root==null)
            return 0;
        return 1 + findLeftHeight(root.left);
    }
    private int findRightHeight(TreeNode root){
        if (root==null)
            return 0;
        return 1 + findRightHeight(root.right);
    }
    //TC is O((logn)^2) and SC is O(logn)
}