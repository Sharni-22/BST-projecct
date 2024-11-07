package com.firstproject;

public class BinarySearch {
    // Node structure
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public BinarySearch() {
        root = null;
    }

    // Insert a node
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Search a node
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search a key in BST
    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Delete a node
    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key in BST
    private Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            root = root.left;
            minValue = root.key;
        }
        return minValue;
    }

    // Print the tree
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the tree
    public static void main(String[] args) {
        BinarySearch tree = new BinarySearch();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the tree:");
        tree.inorder();

        System.out.println("\n\nDeleting 20");
        tree.deleteKey(20);
        tree.inorder();

        System.out.println("\n\nSearching for 40: " + tree.search(40));
    }
}
