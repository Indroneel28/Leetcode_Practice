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
    //Used by Striver
    public TreeNode deleteNode(TreeNode root, int key) {
        
        //Edge cases
        if (root==null)
            return null;
        if (root.val==key)
            return helper(root);
        
        TreeNode p= root;
        while (p!=null){
            if (p.val>key){
                if (p.left!=null && p.left.val==key)
                    p.left= helper(p.left);
                else
                    p= p.left;
            }
            else{
                if (p.right!=null && p.right.val==key)
                    p.right= helper(p.right);
                else
                    p= p.right;
            }
        }
        return root;
    }
    private TreeNode helper(TreeNode root){
        if (root.left==null)
            return root.right;
        else if (root.right==null)
            return root.left;
        else {
            TreeNode r= root.right;
            TreeNode last= findLastRight(root.left);
            last.right= r;
            return root.left;
        }
    }
    private TreeNode findLastRight(TreeNode node){
        while (node.right!=null)
            node= node.right;
        return node;
    }
    //TC is O(logn) and SC is O(1)
}