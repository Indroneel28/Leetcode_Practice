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
    //METHOD 1:- Searching and Inserting at vacant place
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode= new TreeNode(val);
        TreeNode p= root;
        
        //Edge case
        if (root==null)
            return newNode;
        
        while (p!=null){
            if (p.val<val){
                if (p.right==null){
                    p.right= newNode;
                    break;
                }
                p= p.right;
            }

            if (val<p.val){
                if (p.left==null){
                    p.left= newNode;
                    break;
                }
                p= p.left;
            }
        }
        return root;
    }
    //TC is O(logn) and SC is O(1)
}