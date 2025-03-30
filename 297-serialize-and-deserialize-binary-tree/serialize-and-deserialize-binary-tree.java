/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //METHOD 1:- LEVEL ORDER TRAVERSAL (BFS)
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";
        StringBuilder sb= new StringBuilder();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            if (node==null){
                sb.append("#,");
                continue;
            }
            sb.append(node.val+",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        Queue<TreeNode> queue= new LinkedList<>();
        String[] str= data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);

        int i=1; //0 already gone to root
        while (i<str.length){
            TreeNode node= queue.poll();
            String l= str[i++];
            String r= str[i++];
            if (!l.equals("#")){
                TreeNode left= new TreeNode(Integer.parseInt(l));
                node.left= left;
                queue.offer(left);
            }
            if (!r.equals("#")){
                TreeNode right= new TreeNode(Integer.parseInt(r));
                node.right= right;
                queue.offer(right);
            }
        }
        return root;
    }
    
    //TC is O(n) and SC is O(n)
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));