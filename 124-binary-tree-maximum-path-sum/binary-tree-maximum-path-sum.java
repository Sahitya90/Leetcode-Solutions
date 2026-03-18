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

    private int maximum;

    public int maxPathSum(TreeNode root) {

        maximum=Integer.MIN_VALUE;

        sum(root);
        return maximum;
    }
    public int sum(TreeNode node){

        if(node==null){
            return 0;
        }
        int left = Math.max(0,sum(node.left));
        int right = Math.max(0,sum(node.right));

        maximum = Math.max(maximum, left+right+node.val);

        return Math.max(left,right)+node.val;
    }
}