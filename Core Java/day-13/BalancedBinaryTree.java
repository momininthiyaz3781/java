package day13;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // A null tree is balanced
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if the current node is balanced and recurse for left and right subtrees
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0; // The height of a null node is 0
        }
        // Compute the height of each subtree and add 1 for the current node
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Constructing a binary tree as an example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Checking if the binary tree is balanced
        System.out.println("Is the binary tree balanced? " + tree.isBalanced(root));
    }
}