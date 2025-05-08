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
    //METHOD 2:- BETTER METHOD
    public boolean case2;
    public void recoverTree(TreeNode root) {
        TreeNode[] store= new TreeNode[4];
        store[0]= null; //store[0] will store previous nodes
        int[] count= new int[1];
        this.case2= true;
        inorder(root,store,count);
        if (case2){
            //swap store[1] and store[2] values
            int x= store[1].val;
            store[1].val= store[2].val;
            store[2].val= x;
        }
    }
    private void inorder(TreeNode root, TreeNode[] store, int[] count){
        if (root==null)
            return;
        inorder(root.left,store,count);
        if (store[0]!=null && root.val<store[0].val){
            if (count[0]==0) {
                store[1] = store[0];
                store[2] = root;
                count[0]++;
            }
            else{
                int x= store[1].val;
                store[1].val= root.val;
                root.val= x;
                this.case2= false;
            }
        }
        store[0]= root;
        inorder(root.right,store,count);
    }
    //TC is O(n) and SC is O(n)
}