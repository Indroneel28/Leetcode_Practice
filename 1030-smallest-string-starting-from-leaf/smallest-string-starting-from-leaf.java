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
    public static String comp= "zzzzzzzzzzzzzzzzzz";
    public String smallestFromLeaf(TreeNode root) {
        String ans= "";
        traverse(ans,root);
        String store= comp;
        comp= "zzzzzzzzzzzzzzzzzz"; //Fot Leetcode testcode static problem
        return store;
    }
    public void traverse(String ans, TreeNode node){
        if (node==null)
            return;
        else {
            ans=((char)(node.val+97))+ans;
            traverse(ans,node.left);
            traverse(ans,node.right);
        }
        if (node.left==null && node.right==null){
            System.out.println(ans);
            if (ans.compareTo(comp) < 0){ //If ans is smaller than comp lexicographically
                comp= ans;
            }
        }
    }
}