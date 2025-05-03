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
    //METHOD 3:- ITERATIVE METHOD
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node= root;
        while (node!=null){
            if (node.val<p.val && node.val<q.val)
                node= node.right;
            else if (node.val>p.val && node.val>q.val) 
                node= node.left;
            else 
                return node;
        }
        return node;
    }
    //TC is O(logn) and SC is O(1)
}