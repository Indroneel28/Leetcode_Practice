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
    public int sumOfLeftLeaves(TreeNode root) {

        //ITERATIVE METHOD
        /*
        int sum=0;
        Queue<TreeNode> queue= new LinkedList<>();
        //We are using Queue becaues we kno very well that Queue is faster than Stack
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node= queue.remove();
            if (node.left!=null && node.left.left==null && node.left.right==null)
                sum+= node.left.val;
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        return sum;
        */

        //RECURSIVE METHOD
        if (root==null)
            return 0;
        int sum=0;
        if (root.left!=null && root.left.left==null && root.left.right==null)
            sum+= root.left.val;
        return sum + sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
}