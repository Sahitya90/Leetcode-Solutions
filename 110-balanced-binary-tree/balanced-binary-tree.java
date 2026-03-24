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
    public boolean isBalanced(TreeNode root) {

        return Check(root) != -1;
    }
    public int Check(TreeNode node){

        if(node == null){
            return 0;
        }
        int LeftSubtree = Check(node.left);
        if (LeftSubtree == -1) {
            return -1;
        } 
        int RightSubtree = Check(node.right);
        if (RightSubtree == -1){ 
            return -1;
        } 

        if(Math.abs(LeftSubtree - RightSubtree) > 1){
            return -1;
        }
        return Math.max(LeftSubtree, RightSubtree) + 1;

    }
}