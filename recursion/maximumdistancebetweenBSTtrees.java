class Solution {
    Integer ans, prev;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = null;
        minDiff(root);
        return ans;
    }
    
    public void minDiff(TreeNode node) {
        if(node == null) return;
        
        minDiff(node.left);
        
        if(prev != null)
            ans = Math.min(ans, node.val - prev);
        
        prev = node.val;
        minDiff(node.right);
    }
}
