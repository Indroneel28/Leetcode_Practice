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

public class Solution {
    //METHOD 1:- USING BFS 
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        //We will check maxDepth of left and right for each node
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
            int left= maxDepth(node.left), right= maxDepth(node.right);
            if(Math.abs(left-right)>1)
                return false;
        }
        return true;
    }
    private int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left= 1 + maxDepth(root.left);
        int right= 1 + maxDepth(root.right);
        return  Math.max(left,right);
    }
}