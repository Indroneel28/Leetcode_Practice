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
class FindElements {
    HashSet<Integer> set;
    
    public FindElements(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        this.set= new HashSet<>();
        set.add(0);
        root.val= 0;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            if (node.left!=null){
                node.left.val= 2*node.val+1;
                set.add(node.left.val);
                queue.add(node.left);
            }
            if (node.right!=null){
                node.right.val= 2*node.val+2;
                set.add(node.right.val);
                queue.add(node.right);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */