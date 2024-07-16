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
    private boolean findPath(TreeNode root, int target, StringBuilder path){
        if (root==null)
            return false;
        if (root.val==target)
            return true;

        path.append("L");
        if (findPath(root.left,target,path))
            return true;
        path.deleteCharAt(path.length()-1); //Delete the last inserted character
        //Backtracking

        path.append("R");
        if (findPath(root.right,target,path))
            return true;
        path.deleteCharAt(path.length()-1); //Delete the last inserted character
        //Backtracking

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath= new StringBuilder();
        StringBuilder destPath= new StringBuilder();

        //Find the paths
        findPath(root,startValue,startPath);
        findPath(root,destValue,destPath);

        int i=0;
        while (i<startPath.length() && i<destPath.length() && startPath.charAt(i)==destPath.charAt(i))
            i++;
        
        StringBuilder result= new StringBuilder();
        for (int j=i; j<startPath.length(); j++)
            result.append("U");
        
        result.append(destPath.substring(i));
        
        return result.toString();
    }
}