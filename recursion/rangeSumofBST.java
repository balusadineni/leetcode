class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSum(root, low, high);
        return sum;
    }
    
    public int rangeSum(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        if(root.val > low) 
            rangeSum(root.left, low, high);
        if(root.val < high)
            rangeSum(root.right, low, high);
        return 0;
    }
}
