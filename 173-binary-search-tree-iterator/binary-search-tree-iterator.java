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

//METHOD 1:- InOrder Traversal
class BSTIterator {
    List<TreeNode> list;
    int pointer;
    public BSTIterator(TreeNode root) {
        this.list= new ArrayList<>();
        this.pointer= 0;
        inOrder(this.list,root);
    } //TC is O(n) during constructor calling
    private void inOrder(List<TreeNode> list, TreeNode root){
        if (root==null)
            return;
        inOrder(list,root.left);
        list.add(root);
        inOrder(list,root.right);
    }

    public int next() {
        return list.get(this.pointer++).val;
    } //TC is O(1)

    public boolean hasNext() {
        return this.pointer < list.size();
    } //TC is O(1)
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */