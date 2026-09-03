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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        

        return inorder(root, k);
    }
    public int inorder(TreeNode node, int k){

        if(node ==  null){
            return -1;
        }

        if(node != null){

            int left = inorder(node.left, k);
            if(left != -1){
                return left;
            }

            count++;
            if(count == k){
                return node.val;
            }

            int right = inorder(node.right, k);
            if(right != -1){
                return right;
            }
        }
        return -1;
    }
}