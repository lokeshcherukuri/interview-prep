package trees;

public class Traversal {

    public void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderRecursive(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrderRecursive(root.getRight());
    }

    public void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getValue() + " ");
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
    }

    public void postOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(root.getLeft());
        postOrderRecursive(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public void inOrderIterative() {
        
    }

    public void preOrderIterative() {

    }

    public void postOrderIterative() {

    }

    public static void main() {

    }
}
