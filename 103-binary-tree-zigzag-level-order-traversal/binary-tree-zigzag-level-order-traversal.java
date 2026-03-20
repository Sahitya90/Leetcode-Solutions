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
import java.util.*; 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true; 
 
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> LL = new LinkedList<>();

            for(int i = 0; i<size; i++){
                TreeNode temp = queue.poll();

                if(flag){
                    LL.addLast(temp.val);
                }
                else{
                    LL.addFirst(temp.val);
                }

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }


            }
            result.add(LL);
            flag= !flag;
        }
        return result;
    }
}