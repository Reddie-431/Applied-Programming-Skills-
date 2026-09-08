import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        // The first node visited at each depth level is the rightmost visible node
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Process right subtree first, then left subtree
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}