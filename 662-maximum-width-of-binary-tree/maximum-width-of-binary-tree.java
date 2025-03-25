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

 class Pair{
        TreeNode root;
        int num;
        public Pair(TreeNode node, int num){
            this.root= node;
            this.num= num;
        }
    }
class Solution {
    //METHOD 1:- LEVEL ORDER TRAVERSAL
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(root,1));

        int width= 0;
        while (!queue.isEmpty()){
            int n= queue.size();
            int min=0, max= 0;
            for (int i=0; i<n; i++){
                Pair p= queue.poll();
                int val= p.num;
                if (p.root.left!=null)
                    queue.offer(new Pair(p.root.left,val*2+1));
                if (p.root.right!=null)
                    queue.offer(new Pair(p.root.right,val*2+2));
                if (i==0)
                    min= p.num;
                if (i==n-1)
                    max= p.num;
            }
            width= Math.max(width,max-min+1);
        }
        return width;
    }
    //TC is O(n) and SC is O(n)
}