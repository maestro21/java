import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Random;
import java.util.function.Consumer;

public class BinaryTree {

    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseInOrder(Consumer<Node> visitor) {
        traverseInOrder(root, visitor);
    }

    private void traverseInOrder(Node node, Consumer<Node> visitor) {
        if (node != null) {
            traverseInOrder(node.left, visitor);
            visitor.accept(node);
            traverseInOrder(node.right, visitor);
        }
    }

    public DefaultMutableTreeNode buildSwingTree() {
        return buildSwingTree(root);
    }

    private DefaultMutableTreeNode buildSwingTree(Node node) {
        DefaultMutableTreeNode root = null;
        if (node != null) {
            root = new DefaultMutableTreeNode(node.value + " (" + node.height + ")");
            if (node.left != null) {
                root.add(buildSwingTree(node.left));
            }
            if (node.right != null) {
                root.add(buildSwingTree(node.right));
            }
        }
        return root;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;

        int lh = height(node.left);
        if (node.left != null) {
            node.left.height = lh;
        }
        int rh = height(node.right);
        if (node.right != null) {
            node.right.height = rh;
        }

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        return false;
    }

    private int height(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            bt.add(rnd.nextInt(200) - 100);
        }
        System.out.print(bt.isBalanced());
    }

    class Node {
        int value;
        Node left;
        Node right;
        int height;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
