package ds.tree.binarytree;

import java.util.Queue;

public class BinaryTree {

    public Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    int index = -1;
    public Node buildPreOrder(Node node, int[] nodes) {
        if (node == null) {
            return newNode(nodes[0]);
        }
        index++;

        Node newNode = newNode(nodes[index]);
        newNode.left = buildPreOrder(node, nodes);
        newNode.right = buildPreOrder(node, nodes);
        return newNode;
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return newNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);
        return 1 + leftCount + rightCount;
    }

    public int sumNodes(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = sumNodes(node.left);
        int rightSum = sumNodes(node.right);
        return node.key + leftSum + rightSum;
    }

    public Node minimum(Node node) {
        Node min = null;
        while (node != null) {
            min = node;
            node = node.left;
        }
        return min;
    }

    public Node maximum(Node node) {
        Node max = null;
        while (node != null) {
            max = node;
            node = node.right;
        }
        return max;
    }

    public Node search(Node root, int key) {
        Node p = root;
        while (p != null) {
            if (key == p.key) {
                return p;
            }
            else if (key < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public Node delete(Node root, int key) {
        Node p = root; // refer to node to be deleted
        Node parent = root; // refer to parent of node to be deleted
        Node inOrderSucc; // refer to inorder succ of node to be deleted

        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }

        while (p != null && p.key != key) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            System.out.println("Node not found:: " + key);
            return null;
        }

        if (p.left != null && p.right != null) {
            parent = p;
            inOrderSucc = p.right;
            while(inOrderSucc.left != null) {
                parent = inOrderSucc;
                inOrderSucc = inOrderSucc.left;
            }
            p.key = inOrderSucc.key;
            p = inOrderSucc;
        }

        if (p.left == null && p.right == null) {
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        if (p.left == null && p.right != null) {
            if (parent.left == p) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        }

        if (p.left != null && p.right == null) {
            if (parent.left == p) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        }
        return root;
    }

    // Inorder traversal visits the left child first, then the root, and then the right child.
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    //  Preorder traversal first visits the root node and then traverses the left and the right subtree.
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Postorder traversal first traverses the left and the right subtree and then visits the root node. It is used to delete the tree
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public void levelOrderOld(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        int diam1 = diameter(node.left);
        int diam2 = diameter(node.right);
        int diam3 = height(node.left) + height(node.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2)) + 1;
    }

    public boolean isSubTree(Node root, Node subTree) {
        if (subTree == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if(root.key == subTree.key) {
            if (isIdentical(root, subTree)) {
                return true;
            }
        }
        return isSubTree(root.left, subTree) || isSubTree(root.right, subTree);
    }

    public boolean isIdentical(Node root, Node subTree) {
        if (root == null && subTree == null) {
            return true;
        }

        if (root == null || subTree == null) {
            return false;
        }

        if (root.key == subTree.key) {
          return isIdentical(root.left, subTree.left) && isIdentical(root.right, subTree.right);
        }
        return false;
    }

    public void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new java.util.LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.key + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }

    public void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(" " + root.key);
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public void printLeafNodes(Node root) {
        if (root == null) {
            return;
        }

        // If node is leaf node, print its data
        if (root.left == null && root.right == null) {
            System.out.print(" " + root.key);
            return;
        }

        // If left child exists, check for leaf recursively
        if (root.left != null) {
            printLeafNodes(root.left);
        }

        // If right child exists, check for leaf recursively
        if (root.right != null) {
            printLeafNodes(root.right);
        }
    }



    public static void main(String[] args) {
        /* Let us create following BST
                50
             /     \
            30      70
           /  \    /  \
         20   40  60   80
     */

        BinaryTree binaryTree = new BinaryTree();
        Node root = null;
        int[] arr = {50, 30, 20, 40, 70, 60, 80};
        for (int i : arr) {
            root = binaryTree.insert(root, i);
        }
//        root = binaryTree.buildPreOrder(null, arr);

        Node searchNode = binaryTree.search(root, 70);
        System.out.println("Item found :: " +  (searchNode != null));

        Node minNode = binaryTree.minimum(root);
        System.out.println("Minimum :: " +  minNode.key);

        Node maxNode = binaryTree.maximum(root);
        System.out.println("Maximum :: " +  maxNode.key);

        System.out.print("In Order :: ");
        binaryTree.inorder(root);
        System.out.println("");
        System.out.print("Pre Order :: ");
        binaryTree.preOrder(root);
        System.out.println("");
        System.out.print("Post Order :: ");
        binaryTree.postOrder(root);
        System.out.println("");

        System.out.println("");
        System.out.print("Level Order ::");
        binaryTree.levelOrder(root);

        System.out.println("Count :: " + binaryTree.countNodes(root));
        System.out.println("Sum :: " + binaryTree.sumNodes(root));
        System.out.println("Height :: " + binaryTree.height(root));
        System.out.println("Diameter :: " + binaryTree.diameter(root));

        binaryTree.delete(root, 40);

        System.out.print("Post Order after deletion :: ");
        binaryTree.postOrder(root);


//
//        System.out.println("");
//        System.out.print("Leaf Nodes ::");
//        binaryTree.printLeafNodes(root);


    }
}
