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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        if(root != null){
            helper(root, new StringBuilder(), result);
        }
        return result;
    }
    public void helper(TreeNode node, StringBuilder currentPaths, List<String> result){

        int size = currentPaths.length();

        currentPaths.append(node.val);

        if(node.left == null && node.right == null){
            result.add(currentPaths.toString());
        }
        else{
            currentPaths.append("->");
            if(node.left != null){
            helper(node.left, currentPaths, result);
        }
        if(node.right != null){
            helper(node.right, currentPaths, result);
        }

        }
        currentPaths.setLength(size);
    }
}