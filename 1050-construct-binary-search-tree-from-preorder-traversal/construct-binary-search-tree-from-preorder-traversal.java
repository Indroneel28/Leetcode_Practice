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
    //METHOD 1:- Brute Force Method
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);
        for (int i=1; i<preorder.length; i++){
            insertNode(root,preorder[i]);;
        }
        return root;
    }
    private void insertNode(TreeNode root, int value){
        TreeNode node= new TreeNode(value);
        TreeNode temp= root;
        while (temp!=null){
            if (temp.val>value){
                if (temp.left==null){
                    temp.left= node;
                    return;
                }
                else 
                    temp = temp.left;
            }
            else{
                if (temp.right==null){
                    temp.right= node;
                    return;
                }
                else 
                    temp = temp.right;
            }
        }
    }
    //TC is O(n^2) and SC is O(1)
}