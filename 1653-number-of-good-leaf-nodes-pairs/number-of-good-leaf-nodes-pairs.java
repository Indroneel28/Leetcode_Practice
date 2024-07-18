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
    private int countGoodPairs = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return countGoodPairs;
    }

    private int[] dfs(TreeNode node, int distance){
        if (node==null)
            return new int[0];
        else if (node.left==null && node.right==null)
            return new int[]{1};

        int[] leftDistances= dfs(node.left,distance);
        int[] rightDistances= dfs(node.right,distance);

        ArrayList<Integer> currentDistances= new ArrayList<>();
        for (int ld: leftDistances){
            if (ld+1<=distance){
                currentDistances.add(ld+1);
            }
        }
        for (int rd: rightDistances){
            if (rd+1<=distance){
                currentDistances.add(rd+1);
            }
        }

        // Count good pairs from distances of left and right children
        for (int ld : leftDistances) {
            for (int rd : rightDistances) {
                if (ld + rd <= distance) {
                    countGoodPairs++;
                }
            }
        }

        int[] result = new int[currentDistances.size()];
        for (int i = 0; i < currentDistances.size(); i++) {
            result[i] = currentDistances.get(i);
        }

        return result;
    }
}