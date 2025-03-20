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
    //METHOD 1:- OPTIMAL METHOD
    public int maxi;
    public int maxPathSum(TreeNode root) {
        maxi= root.val;
        maxSum(root);
        return maxi;
    }
    private int maxSum(TreeNode node){
        if (node==null)
            return 0;
        int l= Math.max(0,maxSum(node.left));
        int r= Math.max(0,maxSum(node.right));
        maxi= Math.max(maxi,l+r+node.val);
        return Math.max(l,r)+node.val;
    }
    //TC is O(n) and SC is O(n)
}