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
    //METHOD 1:- USING RECURSION
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap= new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        TreeNode node= buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1, inMap);
        return node;
    }
    private TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, Map<Integer,Integer> inMap){
        if (inStart>inEnd || postStart>postEnd)
            return null;
        TreeNode node= new TreeNode(postOrder[postEnd]);
        int rootIndex= inMap.get(postOrder[postEnd]);

        int numsLeft= rootIndex-inStart;

        node.left= buildTree(inOrder,inStart,rootIndex-1,postOrder,postStart,postStart+numsLeft-1,inMap);
        node.right= buildTree(inOrder,rootIndex+1,inEnd,postOrder,postStart+numsLeft,postEnd-1,inMap);
        return node;
    }
    //TC is O(n) and SC is O(n)
}