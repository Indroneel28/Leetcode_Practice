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
    public static TreeNode n;
    public static int maxHeight= 0;
    public int findBottomLeftValue(TreeNode root) {
        find(root,1);
        int value= n.val;
        n= null; maxHeight= 0;
        return value;
    }
    public static void find(TreeNode node, int height){
        if (node==null)
            return;
        if (height>maxHeight){
            maxHeight= height;
            n= node;
        }
        find(node.left,height+1);
        find(node.right,height+1);
    }
}