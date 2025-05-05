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
 
//METHOD 2:- USING STACK
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack= new Stack<>();
        insertNode(root,stack);
    }
    private void insertNode(TreeNode node, Stack<TreeNode> stack){
        while (node!=null){
            stack.add(node);
            node= node.left;
        }
    }

    public int next() {
        TreeNode node= this.stack.pop();
        insertNode(node.right,stack);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
//TC is Amortized O(1) and SC is O(height of tree) for Stack

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */