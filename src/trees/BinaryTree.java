package trees;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Time Complexity = O(n)
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    // Time Complexity = O(n)
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        int rootValue = root.getValue();
        if (rootValue <= min || rootValue > max) {
            return false;
        }

        return isBST(root.getLeft(), min, rootValue) && isBST(root.getRight(), rootValue, max);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }


    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.setLeft(new TreeNode(-10));
        tree.root.setRight(new TreeNode(19));
        tree.root.getLeft().setLeft(new TreeNode(-20));
        tree.root.getLeft().setRight(new TreeNode(0));
        tree.root.getRight().setLeft(new TreeNode(17));

        System.out.println("Size:" + tree.size(tree.root));
        System.out.println("Height:" + tree.height(tree.root));
        System.out.println("isBST:" + tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.print("\nInOrder:");
        tree.inOrder(tree.root);

        System.out.print("\nPreOrder:");
        tree.preOrder(tree.root);

        System.out.print("\nPostOrder:");
        tree.postOrder(tree.root);
    }
}
