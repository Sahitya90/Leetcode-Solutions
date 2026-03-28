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
    int maximum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        sum(root);
        return maximum;
    }
    public int sum(TreeNode node){

        if(node == null){
            return 0;
        }

        int left = Math.max(0,sum(node.left));
        int right = Math.max(0,sum(node.right));

        int currentSum = node.val + left + right;

        maximum = Math.max(maximum, currentSum);


        return node.val + Math.max(left, right);

    }
}