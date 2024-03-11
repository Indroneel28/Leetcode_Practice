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
class CBTInserter {
    //All nodes are as far left as possible
    //So, we need to do BFS
    TreeNode root;
    Queue<TreeNode> queue= new LinkedList<>();
    
    public int add(int val){
        while (!queue.isEmpty()){
            TreeNode node= queue.peek();
            if (node.left!=null) {
                queue.add(node.left);
            }
            else{
                node.left= new TreeNode(val);
                queue.add(node.left);
                return node.val; //break it
            }
            if (node.right!=null) {
                queue.add(node.right);
                queue.remove();
            }
            else{
                node.right= new TreeNode(val);
                queue.add(node.right);
                queue.remove();
                return node.val; //break it
            }
        }
        return -1;
    }
    public CBTInserter(TreeNode root) {
        this.root= root;
        queue.add(root);
    }

    public int insert(int val) {
        return add(val);
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */