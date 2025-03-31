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
    //METHOD 2:- ITERATIVE METHOD
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode p= root;
        while (p!=null){
            if (p.val==val)
                return p;
            else if (val < p.val)
                p= p.left;
            else 
                p= p.right;
        }
        return p;
    }
    //TC is O(logn) and SC is O(1)
}