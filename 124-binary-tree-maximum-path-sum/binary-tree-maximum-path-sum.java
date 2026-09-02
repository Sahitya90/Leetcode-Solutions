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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root != null){
            maxGain(root);
        }
        return maxSum;
    }
    public int maxGain(TreeNode node){    
        
        if(node == null){
            return 0;
        }

        int left = maxGain(node.left);
        int right = maxGain(node.right);

        int leftGain = Math.max(0, left);
        int rightGain = Math.max(0, right);

        maxSum = Math.max(maxSum, leftGain + rightGain + node.val);

        return node.val + Math.max(leftGain, rightGain);
        
    }
}