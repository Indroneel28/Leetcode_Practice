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
    //METHOD 1:- RECURSIVE METHOD
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        else if (root.val<key) //Move right
            root.right= deleteNode(root.right,key);
        else if (key<root.val)//Move left
            root.left= deleteNode(root.left,key);
        else {
            //root needs to be deleted
            //Case 1:- No child
            if (root.left==null && root.right==null)
                return null;
            else if (root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;
            else {
                TreeNode newNode= findMin(root.right);
                root.val= newNode.val;
                root.right= deleteNode(root.right, newNode.val);
            }
        }
        return root;
    }
    private TreeNode findMin(TreeNode root){
        while (root.left!=null)
            root= root.left;
        return root;
    }
    //TC is O(logn) and SC is O(logn)
}