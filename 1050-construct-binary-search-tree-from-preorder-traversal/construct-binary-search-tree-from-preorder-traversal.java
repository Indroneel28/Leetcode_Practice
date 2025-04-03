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
    //METHOD 1:- CONSTRUCTING THE BST
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);
        for (int i=1; i<preorder.length; i++){
            TreeNode node= new TreeNode(preorder[i]);
            TreeNode p= root;
            while (p!=null){
                if (node.val<p.val){
                    if (p.left==null) {
                        p.left = node;
                        break;
                    }
                    p= p.left;
                }
                else {
                    if (p.right==null){
                        p.right= node;
                        break;
                    }
                    p= p.right;
                }
            }
        }
        return root;
    }
    //TC is O(nlogn) and SC is O(1)
}