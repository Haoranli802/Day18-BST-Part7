class Solution {
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur != null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                if(pre != null){
                    result = Math.min(result, Math.abs(cur.val - pre.val));
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}
// O(N), O(N) 层序遍历

class Solution {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
    private void traversal(TreeNode cur){
        if(cur == null) return;
        traversal(cur.left);
        if(pre == null){
            pre = cur;
        }
        else{
            result = Math.min(result, Math.abs(cur.val - pre.val));
            pre = cur;
        }
        traversal(cur.right);
    }
}
//O(N), O(N), 递归
