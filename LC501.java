class Solution {
    List<Integer> result;
    int cur = 0;
    int max = -1;
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(pre == null || pre.val != root.val){
            pre = root;
            cur = 1;
        }
        if(pre.val == root.val){
            cur ++;
        }
        if(cur > max){
            result.clear();
            result.add(root.val);
            max = cur;
        }
        else if(cur == max){
            result.add(root.val);
        }
        helper(root.right);
    }
}
