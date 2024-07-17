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
    private void postOrderTraversal(TreeNode node, HashSet<Integer> nodesToBeDeleted, List<TreeNode> newRoots){
        if (node==null)
            return;
        postOrderTraversal(node.left,nodesToBeDeleted,newRoots);
        postOrderTraversal(node.right,nodesToBeDeleted,newRoots);

        if (node.left!=null && nodesToBeDeleted.contains(node.left.val)){
            if (node.left.left!=null){
                newRoots.add(node.left.left);
            }
            if (node.left.right!=null){
                newRoots.add(node.left.right);
            }
            node.left= null;
        }

        if (node.right!=null && nodesToBeDeleted.contains(node.right.val)){
            if (node.right.left!=null)
                newRoots.add(node.right.left);
            if (node.right.right!=null)
                newRoots.add(node.right.right);
            node.right= null;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //METHOD:- DFS TRAVERSAL
        HashSet<Integer> nodesToBeDeleted= new HashSet<>();
        for (int ele: to_delete)
            nodesToBeDeleted.add(ele);

        List<TreeNode> roots= new ArrayList<>();
        if (root==null || (nodesToBeDeleted.contains(root.val) && root.left==null && root.right==null))
            return roots; //Empty list is the naswer

        postOrderTraversal(root,nodesToBeDeleted,roots);
        if (!nodesToBeDeleted.contains(root.val))
            roots.add(root);
        else{
            if (root.left!=null)
                roots.add(root.left);
            if (root.right!=null)
                roots.add(root.right);
        }
        return roots;
    }
}