public class diameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int left = depth(root);
        return res-1;
    }
    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        res = Math.max(res,left+right);
        return Math.max(left,right)+1;
    }
}
