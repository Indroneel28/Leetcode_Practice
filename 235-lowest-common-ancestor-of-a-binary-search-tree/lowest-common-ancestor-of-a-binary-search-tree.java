/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //METHOD 1:- CONCEPT OF LCA OF BT
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root,p,q);
    }
    private TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)
            return null;
        TreeNode l= traverse(root.left,p,q);
        TreeNode r= traverse(root.right,p,q);
        if (l!=null && r!=null)
            return root;
        else if (root==p || root==q)
            return root;
        else if (l!=null)
            return l;
        else if (r!=null)
            return r;
        else //both are null
            return null;
    }
    //TC is O(n) and SC is O(n)
}