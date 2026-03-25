class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            // We start with one single StringBuilder
            buildPath(root, new StringBuilder(), result);
        }
        return result;
    }

    private void buildPath(TreeNode node, StringBuilder currentPath, List<String> result) {
        
        // 1. THE SAVE STATE (Crucial for Backtracking)
        // We remember exactly how long the string was before we touched it
        int originalLength = currentPath.length();

        // 2. Add the current node's value
        currentPath.append(node.val);

        // 3. THE GOAL: Are we at a leaf?
        if (node.left == null && node.right == null) {
            result.add(currentPath.toString()); // Save the finished path!
        } else {
            // 4. EXPLORE: Add the arrow and keep digging
            currentPath.append("->");
            if (node.left != null) {
                buildPath(node.left, currentPath, result);
            }
            if (node.right != null) {
                buildPath(node.right, currentPath, result);
            }
        }

        // 5. THE BACKTRACK (Clean up!)
        // Before we bounce back up to the parent, we chop off everything 
        // we just added. This leaves the StringBuilder perfectly clean 
        // for the sibling branch to use!
        currentPath.setLength(originalLength);
    }
}