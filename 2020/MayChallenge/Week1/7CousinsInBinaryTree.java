import java.util.Objects;

/**
    Cousins in Binary Tree
    ----------------------
    In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
    Return true if and only if the nodes corresponding to the values x and y are cousins.

    Example 1:
        Input: root = [1,2,3,4], x = 4, y = 3
        Output: false

    Example 2:
        Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
        Output: true

    Example 3:
        Input: root = [1,2,3,null,4], x = 2, y = 3
        Output: false

    Note:
        The number of nodes in the tree will be between 2 and 100.
        Each node has a unique integer value from 1 to 100.
 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TreeNodeSolution {
    class NewNode {
        int depth;
        int parent;

        NewNode(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }
        
        @Override
        public String toString() {
            return "NewNode{" +
                    "depth=" + depth +
                    ", parent=" + parent +
                    '}';
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (!Objects.nonNull(root))
            return false;

        NewNode xNode = findNode(root, x, 0, root.val);
        NewNode yNode = findNode(root, y, 0, root.val);
        
        System.out.println("xNode :: " + xNode);
        System.out.println("yNode :: " + yNode);

        if (!Objects.nonNull(xNode) || !Objects.nonNull(yNode))
            return false;

        if (xNode.depth == yNode.depth && xNode.parent != yNode.parent)
            return true;
        return false;
    }

    public NewNode findNode(TreeNode node, int x, int depth, int parent) {
        if (!Objects.nonNull(node))
            return null;
        ++depth;
        if (node.val == x) {
            return new NewNode(depth, parent);
        }
        NewNode node1 = findNode(node.left, x, depth, node.val);
        NewNode node2 = findNode(node.right, x, depth, node.val);

        return node1 != null ? node1 : node2;
    }
}