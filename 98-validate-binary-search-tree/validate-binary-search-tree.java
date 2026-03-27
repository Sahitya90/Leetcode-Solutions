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
    public boolean isValidBST(TreeNode root) {
        
        return BST(root, null, null);
    }
    public boolean BST(TreeNode node, Integer min_value, Integer max_value){

        if(node== null){
            return true;
        }

        if((min_value != null &&node.val <= min_value) || (max_value != null && node.val >= max_value)){
            return false;
        }

        boolean left = BST(node.left, min_value, node.val);
        boolean right = BST(node.right, node.val, max_value);

        return left && right;
    }
}