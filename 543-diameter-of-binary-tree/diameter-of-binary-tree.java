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
    //METHOD 2:- USING DFS(OPTIMIZED)
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi= new int[1];
        //maxi[0]= 0; //By default 0 in java
        maxDepth(root,maxi);
        return maxi[0];
    }
    private int maxDepth(TreeNode node, int[] maxi){
        if (node==null)
            return 0;
        int l= maxDepth(node.left,maxi);
        int r= maxDepth(node.right,maxi);
        maxi[0]= Math.max(maxi[0],l+r);
        return Math.max(l,r)+1;
    }
    //TC is O(n) and SC is O(n)
}