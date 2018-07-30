package trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SpiralPrinting {

    public void print(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                if (root.getLeft() != null) {
                    stack2.push(root.getLeft());
                }
                if (root.getRight() != null) {
                    stack2.push(root.getRight());
                }
                System.out.print(root.getValue() + " ");
            }

            while (!stack2.isEmpty()) {
                root = stack2.pop();
                if (root.getRight() != null) {
                    stack1.push(root.getRight());
                }
                if (root.getLeft() != null) {
                    stack1.push(root.getLeft());
                }
                System.out.print(root.getValue() + " ");
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

        SpiralPrinting spiralPrinting = new SpiralPrinting();
        spiralPrinting.print(tree.root);
    }
}
