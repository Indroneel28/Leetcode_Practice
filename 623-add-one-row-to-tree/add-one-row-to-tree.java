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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1){
            TreeNode node= new TreeNode(val);
            node.left= root;
            return node;
        }
        //DOING DFS
        dfs(root,depth,val);
        return root;
    }
    public void dfs(TreeNode node, int depth, int val){
        if (node==null)
            return;
        if (depth==2){
            if (node.left!=null){
                TreeNode l= new TreeNode(val);
                l.left= node.left;
                node.left= l;
            }
            else
                node.left= new TreeNode(val);
            if (node.right!=null){
                TreeNode r= new TreeNode(val);
                r.right= node.right;
                node.right= r;
            }
            else 
                node.right= new TreeNode(val);
            return;
        }
        dfs(node.left,depth-1,val);
        dfs(node.right,depth-1,val);
    }
}