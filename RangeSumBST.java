// Time Complexity : O(n) where n is number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Traverse the tree using any order. We ca use conditonal to check if a node is equal to low, we 
/// need not go to it's left subtree coz by BST property, all nodes in left subtree are less than low. Same for 
/// high, don't traverse right sub tree if current node's val==high
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //postorder iterative solution
        int sum =0;
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root != null){
                st.push(root);
                if(root.val>low)
                    root = root.left;
                else
                    break;
            }
            if(st.isEmpty()){
                break;
            }
            root = st.pop();
            if(root.right==null){
                System.out.println(root.val);
                if(root.val>=low && root.val<=high){
                    sum+=root.val;
                }
                root = null;
            }
            else{
                st.push(root);
                TreeNode right = root.right;
                root.right = null;
                if(root.val<high)
                    root = right;
                else
                    root = null;
            }
        }
        return sum;
    }
}