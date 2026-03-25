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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root != null){
            height(root);
        }
        return maxDiameter;
    }
    public int height(TreeNode node){

        if(node == null){
            return 0;
        }

        int leftSubtree = height(node.left);
        int rightSubtree = height(node.right);

        int currentDiameter = leftSubtree + rightSubtree;
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        

        return Math.max(leftSubtree, rightSubtree) +1;
    }
}