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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){
            return true;
        }
        return mirror(root.left, root.right);
    }
    public boolean mirror(TreeNode leftTree, TreeNode rightTree){

        if((leftTree == null) && (rightTree == null)){
            return true;
        }
        if((leftTree == null) || (rightTree == null) || (leftTree.val != rightTree.val)){
            return false;
        }
        
        boolean left = mirror(leftTree.left, rightTree.right);
        boolean right = mirror(leftTree.right, rightTree.left);

        return left && right;

    }
}