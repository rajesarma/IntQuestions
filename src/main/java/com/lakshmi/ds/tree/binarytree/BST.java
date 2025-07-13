package com.lakshmi.ds.tree.binarytree;

public class BST {
    public Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public boolean search(Node root, int key) {
        if (null == root) {
            return false;
        } else if (key == root.key) {
            return true;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node inOrderSuccessor(Node root, int key) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node delete(Node root, int key) {
        if (root.key > key) {
            root.left = delete(root.left, key);
        } else if (root.key < key) {
            root.left = delete(root.right, key);
        } else {
            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node ioS = inOrderSuccessor(root, key);
            root.key = ioS.key;
            root.right = delete(root.right, ioS.key);
        }
        return root;
    }


}
