package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Traversals {

    public void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderRecursive(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrderRecursive(root.getRight());
    }

    public void inOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.getLeft();
        }

        while (! stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.getValue() + " ");
            if (root.getRight() != null) {
                root = root.getRight();
                stack.push(root);
                while (root.getLeft() != null) {
                    root = root.getLeft();
                    stack.push(root);
                }
            }
        }
    }

    public void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getValue() + " ");
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
    }

    public void preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            System.out.print(root.getValue() + " ");
            stack.push(root);
            root = root.getLeft();
        }

        while (! stack.isEmpty()) {
            root = stack.pop();
            if (root.getRight() != null) {
                root = root.getRight();
                while (root != null) {
                    System.out.print(root.getValue() + " ");
                    stack.push(root);
                    root = root.getLeft();
                }
            }
        }
    }

    public void postOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(root.getLeft());
        postOrderRecursive(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public void postOrderIterative(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.getLeft() != null) {
                stack1.push(root.getLeft());
            }
            if (root.getRight() != null) {
                stack1.push(root.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getValue() + " ");
        }
    }

    public void levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>(10);
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            System.out.print(root.getValue() + " ");
            if (root.getLeft() != null) {
                queue.add(root.getLeft());
            }
            if (root.getRight() != null) {
                queue.add(root.getRight());
            }
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

        Traversals traversals = new Traversals();
        System.out.println("In Order Traversal:");
        traversals.inOrderRecursive(tree.root);
        System.out.println("\n");
        traversals.inOrderIterative(tree.root);
        System.out.println("\n");

        System.out.println("Pre Order Traversal:");
        traversals.preOrderRecursive(tree.root);
        System.out.println("\n");
        traversals.preOrderIterative(tree.root);
        System.out.println("\n");

        System.out.println("Post Order Traversal:");
        traversals.postOrderRecursive(tree.root);
        System.out.println("\n");
        traversals.postOrderIterative(tree.root);
        System.out.println("\n");

        System.out.println("Level Order Traversal:");
        traversals.levelOrder(tree.root);
    }
}
