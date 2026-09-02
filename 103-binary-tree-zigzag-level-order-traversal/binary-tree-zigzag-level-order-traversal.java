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
import java.util.Collections;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        boolean reverse = false;
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                list.add(temp.val);

                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            if(reverse == true){
                Collections.reverse(list);
            }
            result.add(list); 
            reverse =  !reverse;           
        }
        return result;
        
    }
}