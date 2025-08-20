// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Traverse using BFS (DFS alos works) For each node maintain column variable. Initially its 0 for root.
/// Left subtree will be called with -1 as column, similary +1 for right subtree. Group them based on column into list
/// To maintain order in the list, in BFS traverse lft subtree first before right
// "static void main" must be defined in a public class.
public class VerticalOrderTraversal
 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        List<ArrayList<Integer>> res = solve(root);
        for(List<Integer> li: res){
            System.out.println(li);
        }
    }
    private static List<ArrayList<Integer>> solve(TreeNode root){
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        q.add(root);
        cq.add(0);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int currCount = cq.poll();
            if(!map.containsKey(currCount)){
                map.put(currCount, new ArrayList<>());
            }
            map.get(currCount).add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
                cq.add(currCount-1);
            }
            if(curr.right!=null){
                q.add(curr.right);
                cq.add(currCount+1);
            }
            min = Math.min(min, currCount);
            max = Math.max(max, currCount);
        }
        List<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        } 
        return res;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
}