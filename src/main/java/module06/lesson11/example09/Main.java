package module06.lesson11.example09;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[] {50, 30, 70, 20, 40, 80}) {
            tree.insert(value);
        }

        System.out.println("insert 30 again: " + tree.insert(30));
        System.out.println("contains 40: " + tree.contains(40));
        System.out.println("contains 65: " + tree.contains(65));
        System.out.println("in-order: " + tree.inOrder());

        BinarySearchTree ascending = new BinarySearchTree();
        for (int value : new int[] {20, 30, 40, 50, 70, 80}) {
            ascending.insert(value);
        }

        System.out.println("ascending in-order: " + ascending.inOrder());
        System.out.println("height: " + tree.height() + " vs. " + ascending.height());
    }
}

class BinarySearchTree {

    private Node root;

    boolean insert(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        Node current = root;
        while (true) {
            if (value == current.getValue()) {
                return false;
            }

            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node(value));
                    return true;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(new Node(value));
                    return true;
                }
                current = current.getRight();
            }
        }
    }

    boolean contains(int value) {
        Node current = root;

        while (current != null) {
            if (value == current.getValue()) {
                return true;
            }

            current = value < current.getValue() ? current.getLeft() : current.getRight();
        }

        return false;
    }

    List<Integer> inOrder() {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        return values;
    }

    private void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft(), values);
        values.add(node.getValue());
        inOrder(node.getRight(), values);
    }

    int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}

final class Node {

    private final int value;
    private Node left;
    private Node right;

    Node(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }
}
