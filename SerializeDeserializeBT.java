// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : For serialization, we traverse tree using BFS (can also do DFS), If root is null need not traverse its children. Reverse
/// the process for deserialization
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder("");
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                res.append("#");
            }
            else{
                res.append(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
            res.append(",");
        }
        System.out.println("res = "+res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String arr[]  = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            curr.left = new TreeNode();
            if(arr[i].equals("#")){
                curr.left = null;
            }
            else{
                curr.left.val = Integer.parseInt(arr[i]);
                q.add(curr.left);
            }
            i++;
            curr.right = new TreeNode();
            if(arr[i].equals("#")){
                curr.right = null;
            }
            else{
                curr.right.val = Integer.parseInt(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));