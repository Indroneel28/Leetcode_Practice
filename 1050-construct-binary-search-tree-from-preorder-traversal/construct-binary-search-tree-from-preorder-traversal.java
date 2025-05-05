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
    //METHOD 2:- Optimal Method
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE, new int[1]);
    }
    public TreeNode bstFromPreorder(int[] preorder, int upperBound, int[] i){
        if (i[0]==preorder.length || preorder[i[0]]>=upperBound)
            return null;
        TreeNode root= new TreeNode(preorder[i[0]++]);
        root.left= bstFromPreorder(preorder,root.val,i);
        root.right= bstFromPreorder(preorder,upperBound,i);
        return root;
    }
    //TC is O(3n) and SC is O(n)
}