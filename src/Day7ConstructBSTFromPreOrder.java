class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Day7ConstructBSTFromPreOrder {

    static int idx;

    public static TreeNode bstFromPreorder(int[] preorder) {
        idx = 0; // initialize index
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode build(int[] preorder, int min, int max) {
        // Base case
        if (idx >= preorder.length) return null;

        int val = preorder[idx];

        // If value doesn't fit in range → not part of this subtree
        if (val < min || val > max) return null;

        // Create node
        TreeNode root = new TreeNode(val);
        idx++;

        // Build left and right
        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }

    // Helper function to print inorder (to verify BST)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main method
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = bstFromPreorder(preorder);

        // Inorder should be sorted if BST is correct
        inorder(root);  // Output: 1 5 7 8 10 12
    }
}